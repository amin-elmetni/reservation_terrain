import React, { useEffect, useState } from 'react';
import { Button } from '@/components/ui/button';
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
  DialogFooter,
  DialogClose,
} from '@/components/ui/dialog';
import { Calendar } from '@/components/ui/calendar';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendar, faClock } from '@fortawesome/free-regular-svg-icons';
import { loadStripe } from '@stripe/stripe-js';
import { Elements, CardElement, useStripe, useElements } from '@stripe/react-stripe-js';
import Swal from 'sweetalert2';
import axios from 'axios';

// Fonction qui enregistre la réservation après le paiement
const handleReservation = async (date, selectedTimeSlot) => {
  const user = JSON.parse(localStorage.getItem('user'));
  const userId = user.id;

  const reservationData = {
    dateCreation: new Date().toISOString(),
    statutReservation: 'CONFIRMEE',
    statutPaiement: 'ACOMPTE',
    dateReservation: date.toISOString(),
    heureReservation: selectedTimeSlot,
    idClient: userId,
  };

  try {
    const response = await axios.post('http://localhost:8090/api/reservations', reservationData);
    Swal.fire({
      title: 'Réservation Confirmée',
      text: 'Votre réservation a été confirmée avec succès!',
      icon: 'success',
      confirmButtonText: 'OK',
      timer: 3000,
    });
  } catch (error) {
    Swal.fire({
      title: 'Erreur',
      text: "Une erreur s'est produite lors de la confirmation de votre réservation.",
      icon: 'error',
      timer: 3000,
    });
  }
};

const stripePromise = loadStripe(
  'pk_test_51QbomrJp77YthrfT7OHv9ZJiBhbswu28p1Q6gdXM9tYtTbM0Mlwh2KIwCxLaH6AFdeMyavRck6Ul2HKpmyB6EvkE00aha7llYZ'
);

//? Valid card inputs :
//* 4242 4242 4242 4242	Visa	Approved for testing (default)
//* 4000 0027 6000 3184	Visa (Debit)	Requires authentication
//* 5555 5555 5555 4444	Mastercard	Approved for testing (default)
//* 5200 8282 8282 8210	Mastercard (Debit)	Approved for testing
//* 3782 8224 6310 005	  American Express	Approved for testing
//* 6011 1111 1111 1117	Discover	Approved for testing
//* 3056 9309 0259 04	  Diners Club	Approved for testing
//* 3566 1111 1111 1113	JCB	Approved for testing

//! Reservation form
const Reservation = ({ terrain }) => {
  const [date, setDate] = useState(new Date());
  const [timeSlot, setTimeSlot] = useState([]);
  const [selectedTimeSlot, setSelectedTimeSlot] = useState();
  const [openDialog, setOpenDialog] = useState({ reservation: false, payment: false });
  const [reservedSlots, setReservedSlots] = useState([]);

  useEffect(() => {
    getTime();
  }, []);

  const getTime = () => {
    const timeList = [];
    for (let i = 7; i <= 24; i++) {
      timeList.push({ time: `${i == 24 ? '00' : i}:00` }); // Format HH:mm
    }
    setTimeSlot(timeList);
  };

  const fetchReservedSlots = async () => {
    try {
      const response = await api.get('/api/reservations');
      // const response = await axios.get('http://localhost:8090/api/reservations'); // Modifier l'URL selon votre API
      setReservedSlots(response.data); // Stocke les créneaux réservés (date et timeSlot)
    } catch (error) {
      console.error('Erreur lors de la récupération des réservations:', error);
    }
  };

  const isDateReserved = selectedDate => {
    // Vérifie si une date est réservée
    return reservedSlots.some(
      reservation => reservation.date === selectedDate.toISOString().split('T')[0]
    );
  };

  const isTimeSlotReserved = (date, timeSlot) => {
    // Vérifie si un créneau horaire est réservé pour la date donnée
    return reservedSlots.some(
      reservation =>
        reservation.date === date.toISOString().split('T')[0] && reservation.timeSlot === timeSlot
    );
  };

  const isPastDate = day => day < new Date();

  const handleReservationClick = () => {
    if (date && selectedTimeSlot) {
      setOpenDialog({ reservation: false, payment: true });
    } else {
      alert('Veuillez sélectionner une date et un créneau horaire.');
    }
  };

  //! CheckoutForm Component
  const CheckoutForm = () => {
    const stripe = useStripe();
    const elements = useElements();

    const handleSubmit = async event => {
      event.preventDefault();

      if (!stripe || !elements) {
        return;
      }

      const { error, paymentMethod } = await stripe.createPaymentMethod({
        type: 'card',
        card: elements.getElement(CardElement),
      });

      if (error) {
        Swal.fire({
          title: 'Payment Failed',
          text: error.message,
          icon: 'error',
          timer: 3000,
        });
        setOpenDialog({ reservation: false, payment: false });
      } else {
        setOpenDialog({ reservation: false, payment: false });
        handleReservation(date, selectedTimeSlot);
      }
    };

    return (
      <form
        onSubmit={handleSubmit}
        className='space-y-6'
      >
        <div className='flex flex-col'>
          <label
            htmlFor='card-details'
            className='text-sm font-medium text-gray-700 mb-2'
          >
            Détails de la carte
          </label>
          <CardElement
            id='card-details'
            className='p-3 border rounded-md'
            options={{
              style: {
                base: { fontSize: '16px', color: '#32325d', '::placeholder': { color: '#aab7c4' } },
                invalid: { color: '#fa755a' },
              },
            }}
          />
        </div>
        <div className='flex flex-row justify-end space-x-4'>
          <Button
            type='button'
            variant='secondary'
            className='text-red-500 bg-gray-100 px-4 py-2 rounded-md hover:bg-red-500/10'
            onClick={() => setOpenDialog({ ...openDialog, payment: false })}
          >
            Annuler
          </Button>
          <Button
            type='submit'
            className='bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700'
            disabled={!stripe}
          >
            Confirmer Paiement
          </Button>
        </div>
      </form>
    );
  };

  return (
    <>
      <Dialog
        open={openDialog.reservation}
        onOpenChange={open => setOpenDialog({ ...openDialog, reservation: open })}
      >
        <DialogTrigger>
          <button className='bg-primary text-white px-4 py-2 rounded-full w-fit text-sm mt-3 font-medium hover:scale-105 transition'>
            Réserver Terrain
          </button>
        </DialogTrigger>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Reservation Terrain</DialogTitle>
            <DialogDescription>
              <div className='grid grid-cols-1 md:grid-cols-2 mt-5'>
                <div className='flex flex-col gap-3 items-baseline'>
                  <div className='flex items-center gap-2'>
                    <FontAwesomeIcon
                      icon={faCalendar}
                      className='text-primary h-5 w-5'
                    />
                    <h2>Sélectionner Date</h2>
                  </div>
                  <Calendar
                    mode='single'
                    selected={date}
                    onSelect={setDate}
                    disabled={isPastDate}
                    className='rounded-md border'
                  />
                </div>
                <div className='mt-3 md:mt-0 flex flex-col gap-3'>
                  <div className='flex items-center gap-2'>
                    <FontAwesomeIcon
                      icon={faClock}
                      className='text-primary h-5 w-5'
                    />
                    <h2>Sélectionner Créneau Horaire</h2>
                  </div>
                  <div className='grid grid-cols-3 gap-2 border rounded-lg p-5'>
                    {timeSlot?.map((item, index) => (
                      <h2
                        key={index}
                        onClick={() => setSelectedTimeSlot(item.time)}
                        className={`p-2 border text-center rounded-full hover:bg-primary hover:text-white cursor-pointer transition ${
                          isTimeSlotReserved(date, item.time)
                            ? 'bg-gray-400 text-gray-700 cursor-not-allowed'
                            : ''
                        } ${item.time === selectedTimeSlot && 'bg-primary text-white'}`}
                        disabled={isTimeSlotReserved(date, item.time)}
                      >
                        {item.time}
                      </h2>
                    ))}
                  </div>
                </div>
              </div>
            </DialogDescription>
          </DialogHeader>
          <DialogFooter className='sm:justify-end'>
            <div className='flex items-center justify-between w-full'>
              <h2 className='font-semibold text-lg text-gray-800'>
                Paiement d'Accompte :
                <span className='text-gold'> {(terrain.prixParHeure * 10) / 100} MAD</span>
              </h2>
              <div className='flex gap-2'>
                <DialogClose asChild>
                  <Button
                    type='button'
                    variant='secondary'
                    className='text-red-500 bg-gray-100 hover:bg-red-500/10'
                  >
                    Annuler
                  </Button>
                </DialogClose>
                <Button
                  type='button'
                  className='text-white'
                  disabled={!(date && selectedTimeSlot)}
                  onClick={handleReservationClick}
                >
                  Reserver
                </Button>
              </div>
            </div>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {openDialog.payment && (
        <Dialog
          open={openDialog.payment}
          onOpenChange={open => setOpenDialog({ ...openDialog, payment: open })}
        >
          <DialogContent>
            <DialogHeader>
              <div className='flex flex-col gap-2 items-start justify-center text-lg mb-4'>
                <h2 className='font-semibold text-center text-gray-800'>
                  Date de Reservation :{' '}
                  <span className='text-primary'>
                    {' '}
                    {date?.toLocaleDateString('fr-FR')}, {selectedTimeSlot}{' '}
                  </span>
                </h2>
                <h2 className='font-semibold text-gray-800'>
                  Paiement d'Acompte :{' '}
                  <span className='text-gold'>{(terrain.prixParHeure * 10) / 100} MAD</span>
                </h2>
              </div>
              <DialogTitle>Checkout</DialogTitle>
            </DialogHeader>
            <Elements stripe={stripePromise}>
              <CheckoutForm />
            </Elements>
          </DialogContent>
        </Dialog>
      )}
    </>
  );
};

export default Reservation;
