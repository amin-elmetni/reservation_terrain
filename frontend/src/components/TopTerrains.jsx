import React, { useContext } from 'react';
import TerrainCard from './reusable/TerrainCard';
import { terrainsData } from '@/assets/assets';
import { useNavigate } from 'react-router-dom';
// import { AppContext } from '@/context/AppContext';

const TopTerrains = () => {
  const navigate = useNavigate();
  // const { terrainsData } = useContext(AppContext);

  return (
    <div className='flex flex-col items-center gap-4 my-16 text-gray-900 md:mx-10'>
      <h1 className='font-medium capitalize text-3xl'>Top Terrain à Réserver</h1>
      <p className='text-center text-sm'>
        Il suffit de parcourir notre vaste liste de terrains de sport
      </p>
      <div className='w-full grid grid-cols-auto gap-4 pt-5 gap-y-6 px-3 sm:px-0'>
        {terrainsData.slice(0, 10).map((item, index) => (
          <TerrainCard
            key={index}
            onClick={() => navigate(`/terrain/${item.id}`)}
            image={item.image}
            disponibilite={item.disponibilite}
            nom={item.nom}
            ville={item.ville}
            capacite={item.capacite}
            type_gazon={item.type_gazon}
          />
        ))}
      </div>
      <button
        onClick={() => {
          navigate('/terrains');
          scrollTo(0, 0);
        }}
        className='bg-blue-100 text-gray-600 px-12 py-3 rounded-full mt-10 hover:scale-105 transition'
      >
        plus
      </button>
    </div>
  );
};

export default TopTerrains;
