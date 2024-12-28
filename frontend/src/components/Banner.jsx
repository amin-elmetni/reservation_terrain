import React from 'react';
import { assets } from '@/assets/assets';

const Banner = () => {
  return (
    <div className='flex bg-primary rounded-lg px-6 sm:px-10 md:px-17 lg:px-12 mb-20 mt-32 md:mx-10'>
      {/* //* ---------- Left Side ---------- */}
      <div className='flex-1 py-8 sm:py-10 md:py-16 lg:py-18 lg:pl-5'>
        <div className='text-xl sm:text-2xl md:text-3xl lg:text-4xl font-semibold text-white'>
          <p>Jouer Match</p>
          <p className='mt-4'>Avec 100+ Terrains sportifs</p>
        </div>
        <button className='bg-white text-sm sm:text-base text-gray-600 px-8 py-3 rounded-full mt-6 hover:scale-105 transition-all'>
          Créer Compte
        </button>
      </div>

      {/* //* ---------- Right Side ---------- */}
      <div className='hidden md:block md:w-1/3 lg:w-[370px] relative'>
        <img
          className='w-full absolute bottom-0 right-0 max-w-md'
          src={assets.banner}
        />
      </div>
    </div>
  );
};

export default Banner;
