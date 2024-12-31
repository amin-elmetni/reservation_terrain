import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import TerrainCard from '../components/reusable/TerrainCard';
import VilleCard from '@/components/reusable/VilleCard';
import { villesData } from '@/assets/assets';

const Terrains = () => {
  const navigate = useNavigate();
  const { ville } = useParams();
  const [terrains, setTerrains] = useState([]);
  const [filteredTerrains, setFilteredTerrains] = useState([]);
  const [loading, setLoading] = useState(true);

  // Fonction pour récupérer les terrains depuis l'API
  const fetchTerrains = async () => {
    try {
      const response = await axios.get('http://localhost:8090/api/terrains');
      setTerrains(response.data);
    } catch (error) {
      console.error('Erreur lors de la récupération des terrains :', error);
    } finally {
      setLoading(false);
    }
  };

  // Filtrer les terrains par ville
  useEffect(() => {
    if (ville) {
      setFilteredTerrains(
        terrains.filter(terrain => terrain.ville.toUpperCase() === ville.toUpperCase())
      );
    } else {
      setFilteredTerrains(terrains);
    }
  }, [terrains, ville]);

  // Charger les terrains au montage du composant
  useEffect(() => {
    fetchTerrains();
  }, []);

  return (
    <div className='py-6'>
      <p className='text-gray-600 text-lg font-medium mb-4'>Parcourir les terrains sportifs</p>
      {loading ? (
        <p className='text-center'>Chargement des terrains...</p>
      ) : (
        <div className='flex flex-col sm:flex-row gap-5'>
          {/* Colonne des villes pour le filtre */}
          <div className='flex flex-col gap-4 text-sm text-gray-600 w-full sm:w-1/4'>
            {villesData.map((item, index) => (
              <VilleCard
                key={index}
                ville={ville}
                city={item.ville}
              />
            ))}
          </div>
          {/* Colonne des terrains */}
          <div className='grid grid-cols-auto gap-6 w-full'>
            {filteredTerrains.map(terrain => (
              <TerrainCard
                key={terrain.id}
                onClick={() => navigate(`/terrain/${terrain.id}`)}
                image={terrain.imageUrl}
                disponibilite={terrain.disponibilite}
                nom={terrain.nom}
                ville={terrain.ville}
                capacite={terrain.capacite}
                type_gazon={terrain.typeGazon}
              />
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

export default Terrains;
