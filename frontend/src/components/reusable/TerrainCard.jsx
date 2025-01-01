import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLocationDot } from '@fortawesome/free-solid-svg-icons';
import { faUser } from '@fortawesome/free-solid-svg-icons';
import { faLeaf } from '@fortawesome/free-solid-svg-icons';

const TerrainCard = ({
  image,
  nom,
  disponibilite,
  capacite,
  ville,
  type_gazon,
  onClick,
}) => {
  return (
    <div
      className='border border-blue-200 rounded-xl overflow-hidden cursor-pointer hover:translate-y-[-10px] transition-all duration-500 hover:border-primary flex flex-col'
      onClick={onClick}
    >
      <img
        src={image}
        className='w-full h-[180px] object-cover'
      />
      <div className='p-4 flex flex-col'>
        {disponibilite ? (
          <div className='flex items-center gap-2 text-sm text-center text-green-500'>
            <p className='w-2 h-2 bg-green-500 rounded-full'></p>
            <p>disponible</p>
          </div>
        ) : (
          <div className='flex items-center gap-2 text-sm text-center text-red-500'>
            <p className='w-2 h-2 bg-red-500 rounded-full'></p>
            <p>non disponible</p>
          </div>
        )}
        <p className='text-gray-900 text-lg font-medium'>{nom}</p>
        <div className='flex flex-col gap-1 text-gray-600 text-sm mt-2 ml-2'>
          <div className='flex items-center gap-3'>
            <FontAwesomeIcon icon={faLocationDot} />
            <p>{ville}</p>
          </div>
          <div className='flex items-center gap-3'>
            <FontAwesomeIcon icon={faUser} />
            <p>{capacite} joueurs</p>
          </div>
          <div className='flex items-center gap-3'>
            <FontAwesomeIcon icon={faLeaf} />
            <p>{type_gazon}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TerrainCard;
