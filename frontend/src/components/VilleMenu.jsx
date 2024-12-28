import React from 'react';
import { villesData } from '../assets/assets';
import { Link } from 'react-router-dom';

const VilleMenu = () => {
  return (
    <div
      id='ville'
      className='flex flex-col items-center gap-4 py-16 text-gray-800'
    >
      <h1 className='text-3xl font-medium'>Recherche par ville</h1>
      <p className='sm:w-1/3 text-center text-sm'>
        Il vous suffit de consulter notre vaste liste de terrains de sport et de prendre rendez-vous
        en toute simplicité.
      </p>
      <div className='flex sm:justify-center gap-4 pt-5 w-full overflow-scroll'>
        {villesData.map((item, index) => (
          <Link
            onClick={() => scrollTo(0, 0)}
            className='flex flex-col items-center text-xs cursor-pointer flex-shrink-0 hover:translate-y-[-10px] transitions-all duration-500'
            key={index}
            to={`/terrains/${item.ville}`}
          >
            <div className='w-16 sm:w-24 mb-2 p-6 rounded-full bg-gray-200 hover:bg-primary transition ease-in-out'>
              <img src={item.image} />
            </div>
            <p>{item.ville}</p>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default VilleMenu;
