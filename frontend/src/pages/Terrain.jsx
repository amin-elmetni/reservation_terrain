import TerrainDetail from '@/components/TerrainDetail';
import TerrainSuggestions from '@/components/TerrainSuggestions';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import api from '@/api'; // Fichier Axios pour les appels API

const Terrain = () => {
  const { id } = useParams(); // Récupérer l'ID depuis l'URL
  const [terrain, setTerrain] = useState(null);
  const [responsable, setResponsable] = useState(null);

  useEffect(() => {
    const fetchTerrainDetails = async () => {
      try {
        // Récupérer les détails du terrain
        const response = await api.get(`/api/terrains/${id}`);
        setTerrain(response.data);

        // Récupérer les détails du responsable
        if (response.data.responsableId) {
          const responsableResponse = await api.get(
            `/api/utilisateurs/${response.data.responsableId}`
          );
          setResponsable(responsableResponse.data);
        }
      } catch (error) {
        console.error('Erreur lors de la récupération des détails du terrain :', error);
      }
    };

    fetchTerrainDetails();
  }, [id]);

  if (!terrain) {
    return <p>Chargement des détails du terrain...</p>;
  }

  return (
    <div className='p-5 m:px-20'>
      <h2 className='font-bold text-[22px]'>Détails</h2>
      <div className='grid grid-cols-1 lg:grid-cols-4 mt-5 gap-5'>
        {/* Terrain details */}
        <div className='col-span-3'>
          <TerrainDetail
            terrain={terrain}
            responsable={responsable}
          />
        </div>
        {/* Terrains suggestions */}
        <div>
          <TerrainSuggestions ville={terrain.ville} />
        </div>
      </div>
    </div>
  );
};

export default Terrain;
