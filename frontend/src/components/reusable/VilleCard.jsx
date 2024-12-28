import React from 'react';
import { useNavigate } from 'react-router-dom';

const VilleCard = ({ ville, city }) => {
  const navigate = useNavigate();

  return (
    <p
      onClick={() => navigate(ville === city ? '/terrains' : `/terrains/${city}`)}
      className={`w-full px-4 py-2 border border-gray-300 rounded cursor-pointer transition-all ${
        ville === city
          ? 'bg-primary text-white hover:scale-105'
          : 'hover:scale-105 hover:border-primary hover:text-primary'
      }`}
    >
      {city}
    </p>
  );
};

export default VilleCard;