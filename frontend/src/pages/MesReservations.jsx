import React, { useEffect, useState } from 'react';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import ReservationsList from '@/components/ReservationsList';
import api from '@/api';

const MesReservations = () => {
  const [reservations, setReservations] = useState({
    CONFIRMEE: [],
    ANNULEE: [],
    EXPIREE: [],
  });
  const userId = JSON.parse(localStorage.getItem('user'))?.id;

  useEffect(() => {
    const fetchReservations = async status => {
      try {
        const response = await api.get(
          `/api/reservations/client?status=${status}&clientId=${userId}`
        );
        setReservations(prev => ({ ...prev, [status]: response.data }));
      } catch (error) {
        console.error(`Erreur lors de la récupération des réservations ${status} :`, error);
      }
    };

    if (userId) {
      ['CONFIRMEE', 'ANNULEE', 'EXPIREE'].forEach(fetchReservations);
    }
  }, [userId]);

  return (
    <div className='px-4 sm:px-10 mt-10'>
      <h2 className='font-bold text-2xl'>Mes Reservations</h2>
      <Tabs
        defaultValue='CONFIRMEE'
        className='w-full mt-5'
      >
        <TabsList className='w-full justify-start'>
          <TabsTrigger value='CONFIRMEE'>Confirmées</TabsTrigger>
          <TabsTrigger value='ANNULEE'>Annulées</TabsTrigger>
          <TabsTrigger value='EXPIREE'>Expirées</TabsTrigger>
        </TabsList>
        {Object.keys(reservations).map(status => (
          <TabsContent
            key={status}
            value={status}
          >
            <div className='flex flex-col gap-4'>
              {reservations[status].map(reservation => (
                <ReservationsList
                  key={reservation.id}
                  reservation={reservation}
                />
              ))}
            </div>
          </TabsContent>
        ))}
      </Tabs>
    </div>
  );
};

export default MesReservations;
