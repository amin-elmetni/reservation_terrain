import React from 'react';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import ReservationsList from '@/components/ReservationsList';

const MesReservations = () => {
  return (
    <div className='px-4 sm:px-10 mt-10'>
      <h2 className='font-bold text-2xl'>Mes Reservations</h2>
      <Tabs
        defaultValue='upcoming'
        className='w-full mt-5'
      >
        <TabsList className='w-full justify-start'>
          <TabsTrigger value='upcoming'>Upcoming</TabsTrigger>
          <TabsTrigger value='expired'>Expired</TabsTrigger>
        </TabsList>
        <TabsContent value='upcoming'>
          <ReservationsList />
        </TabsContent>
        <TabsContent value='expired'>
          <ReservationsList />
        </TabsContent>
      </Tabs>
    </div>
  );
};

export default MesReservations;
