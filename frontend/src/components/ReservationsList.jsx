import React, { useEffect, useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAddressBook, faCalendarCheck, faClock } from '@fortawesome/free-regular-svg-icons';
import api from '@/api';
import { format, parse } from 'date-fns';

const ReservationsList = ({ reservation }) => {
  const [terrain, setTerrain] = useState({});
  const [responsable, setResponsable] = useState({});

  useEffect(() => {
    const fetchTerrainDetails = async () => {
      try {
        // Récupérer les détails du terrain
        const response = await api.get(`/api/terrains/${reservation.idTerrain}`);
        setTerrain(response.data);

        // Récupérer les détails du responsable
        if (response.data.responsableId) {
          const responsableResponse = await api.get(
            `/api/utilisateurs/${response.data.responsableId}`
          );
          setResponsable(responsableResponse.data);
        }
      } catch (error) {
        console.error('Erreur lors de la récupération des détails du terrain :', error);
      }
    };

    fetchTerrainDetails();
  }, []);

  const cancelReservation = reservationId => {
    api
      .put(`/api/reservations/${reservationId}/annuler`)
      .then(() => {
        window.location.reload(); // Recharge la page une fois la fenêtre fermée
      })
      .catch(error => console.error("Erreur lors de l'annulation:", error));
  };

  const formatDate = dateString => {
    const date = new Date(dateString);
    const formatter = new Intl.DateTimeFormat('fr-FR', {
      day: '2-digit',
      month: 'short',
      year: 'numeric',
    });
    return formatter.format(date);
  };

  const formatTime = timeString => {
    const date = parse(timeString, 'HH:mm:ss', new Date()); // Si `timeString` est sous forme `HH:mm:ss`
    return format(date, 'h:mm a'); // Affiche au format "3:00 AM"
  };

  const formatPhoneNumber = phone => {
    return phone?.replace(/(\d{2})(?=\d)/g, '$1 '); // Ajoute un espace après chaque deux chiffres
  };

  const formattedDate = formatDate(reservation?.dateReservation);
  const formattedTime = formatTime(reservation?.heureReservation);
  const formattedPhone = formatPhoneNumber(responsable?.telephone);

  return (
    <div className='flex flex-col lg:flex-row lg:justify-between p-4 border rounded-lg gap-4 hover:bg-gray-100'>
      <div className='flex items-center gap-4'>
        <img
          src={terrain?.imageUrl}
          className='h-[130px] w-[200px] border-primary  object-cover rounded-lg'
        />
        <div className='flex flex-col font-medium gap-[6px]'>
          {/* ici je veux le nom du terrain */}
          <h2 className='font-bold text-xl'>{terrain?.nom}</h2>
          <div className='flex gap-2 items-center'>
            <FontAwesomeIcon
              icon={faAddressBook}
              className='text-primary text-lg'
            />
            {/* ici je veux le nom du responsable de terrain et son numéro */}
            <h2 className='text-gray-500 capitalize'>
              {responsable?.nom} - {formattedPhone}
            </h2>
          </div>
          <div className='flex gap-2 items-center ml-[1px]'>
            <FontAwesomeIcon
              icon={faCalendarCheck}
              className='text-primary text-lg'
            />
            {/* ici je veux la date de reservation */}
            <h2>Réservation Le : {formattedDate}</h2>
          </div>
          <div className='flex gap-2 items-center'>
            <FontAwesomeIcon
              icon={faClock}
              className='text-primary text-lg'
            />
            {/* ici je veux l'heure de reservation */}
            <h2>À L'heure : {formattedTime}</h2>
          </div>
        </div>
      </div>
      {reservation.statutReservation == 'CONFIRMEE' && (
        <button
          onClick={() => cancelReservation(reservation?.id)}
          className='self-start w-full lg:w-fit border px-4 py-2 rounded-lg text-red-500 border-red-500 font-semibold text-sm hover:bg-red-500 hover:text-white transition-all bg-white'
        >
          Annuler Réservation
        </button>
      )}
    </div>
  );
};

export default ReservationsList;
