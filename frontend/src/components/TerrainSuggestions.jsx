import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import TerrainSuggetionCard from './reusable/TerrainSuggetionCard';
import api from '@/api';

const TerrainSuggetions = ({ ville }) => {
  const [terrains, setTerrains] = useState([]);

  useEffect(() => {
    const fetchTerrainsByVille = async () => {
      try {
        const response = await api.get(`/api/terrains/ville/${ville}`);
        setTerrains(response.data);
      } catch (error) {
        console.error('Erreur lors de la récupération des terrains par ville :', error);
      }
    };

    if (ville) {
      fetchTerrainsByVille();
    }
  }, [ville]);

  if (terrains.length === 0) {
    return <p>Chargement des suggestions...</p>;
  }

  return (
    <div className='flex flex-col border-[1px] p-5 rounded-lg gap-4'>
      <h2 className='font-bold text-lg'>Suggestions</h2>
      {terrains.map(terrain => (
        <TerrainSuggetionCard
          key={terrain.id}
          terrain={terrain}
        />
      ))}
    </div>
  );
};

export default TerrainSuggetions;
