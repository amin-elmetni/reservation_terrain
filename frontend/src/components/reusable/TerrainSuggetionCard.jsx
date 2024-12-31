import React from 'react';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFutbol, faLocationDot } from '@fortawesome/free-solid-svg-icons';

const TerrainSuggetionCard = ({ terrain }) => {
  const navigate = useNavigate(); // Hook pour naviguer entre les pages

  const handleClick = () => {
    navigate(`/terrain/${terrain.id}`); // Redirige vers la page des détails du terrain
  };

  return (
    <div onClick={handleClick}>
      <div
        key={terrain.id}
        className='flex items-center gap-2 hover:bg-primary hover:bg-opacity-5 p-4 rounded-lg cursor-pointer transition-all border-b'
      >
        <img
          src={terrain.imageUrl}
          alt={terrain.nom}
          className='w-20 h-20 object-cover rounded-lg'
        />
        <div className='flex flex-col gap-1'>
          <h2 className='text-[10px] bg-primary bg-opacity-10 p-1 rounded-full text-primary font-medium px-2 flex gap-1 items-center w-fit'>
            <FontAwesomeIcon icon={faFutbol} />
            <p>Football</p>
          </h2>
          <p className='text-gray-900 font-semibold capitalize text-sm'>{terrain.nom}</p>
          <div className='flex items-center gap-1 text-xs text-primary'>
            <FontAwesomeIcon icon={faLocationDot} />
            <p>{terrain.ville}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TerrainSuggetionCard;
