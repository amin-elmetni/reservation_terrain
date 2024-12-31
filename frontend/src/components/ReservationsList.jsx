import { assets } from '@/assets/assets';
import React from 'react';

const ReservationsList = () => {
  return (
    <div className='flex p-4 border rounded-lg'>
      <img
        src={assets.limpica}
        className='h-[70px] w-[100px] object-cover rounded-lg'
      />
      <div className='flex flex-col'>
        <h2 className=''>Limpica</h2>
        <h2>addresse</h2>
      </div>
    </div>
  );
};

export default ReservationsList;
