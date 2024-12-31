import React from 'react';
import Reservation from './Reservation';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faLocationDot,
  faMapPin,
  faUser,
  faLeaf,
  faFutbol,
  faSun,
  faIdCard,
  faPhone,
  faEnvelope,
  faCoins,
} from '@fortawesome/free-solid-svg-icons';

const TerrainDetail = ({ terrain, responsable }) => {
  return (
    <div className='flex flex-col gap-5'>
      <div className='grid gap-2 grid-cols-1 md:grid-cols-7 border-[1px] p-5 rounded-lg'>
        <div className='col-span-4'>
          <img
            src={terrain.imageUrl}
            alt={terrain.nom}
            className='rounded-lg w-full h-[300px] md:h-[270px] object-cover'
          />
        </div>

        <div className='p-4 flex flex-col gap-1 col-span-3 items-start'>
          <div
            className={`flex items-center gap-2 text-sm ${
              terrain.disponibilite ? 'text-green-500' : 'text-red-500'
            }`}
          >
            <p className='w-2 h-2 bg-green-500 rounded-full'></p>
            <p>{terrain.disponibilite ? 'Disponible' : 'Indisponible'}</p>
          </div>

          <div className='flex items-center gap-5'>
            <p className='text-gray-900 text-2xl font-bold'>{terrain.nom}</p>
            <h2 className='text-[10px] bg-primary bg-opacity-10 p-1 rounded-full text-primary font-medium px-2 flex gap-1 items-center'>
              <FontAwesomeIcon icon={faFutbol} />
              <p>Football</p>
            </h2>
          </div>
          <div className='flex flex-col gap-2 text-gray-600 text-sm mt-2 ml-2'>
            <div className='flex items-center gap-3'>
              <FontAwesomeIcon icon={faLocationDot} />
              <p>{terrain.ville}</p>
            </div>
            <div className='flex items-center gap-3'>
              <FontAwesomeIcon
                icon={faMapPin}
                className='text-lg'
              />
              <p className='capitalize'>{terrain.adresse}</p>
            </div>
            <div className='flex items-center gap-3'>
              <FontAwesomeIcon icon={faUser} />
              <p>{terrain.capacite} joueurs</p>
            </div>
            <div className='flex items-center gap-2 text-[24px] text-gold my-2 font-semibold'>
              <FontAwesomeIcon icon={faCoins} />
              <p>{terrain.prixParHeure} MAD</p>
            </div>
          </div>
          <Reservation terrain={terrain} />
        </div>
      </div>

      <div className='flex flex-col gap-4 border-[1px] p-5 rounded-lg'>
        <h2 className='font-bold text-lg'>Informations Complémentaires</h2>

        <div className='flex gap-4 flex-col lg:flex-row'>
          {responsable && (
            <div className='flex flex-col gap-3 flex-auto bg-primary bg-opacity-[0.07] p-6 rounded-lg'>
              <h2 className='font-medium'>Responsable</h2>
              <div className='flex gap-7 text-[13px]'>
                <div className='flex gap-2 items-center'>
                  <FontAwesomeIcon
                    icon={faIdCard}
                    className='text-primary text-xl'
                  />
                  <p className='capitalize'>{responsable.nom}</p>
                </div>
                <div className='flex gap-2 items-center'>
                  <FontAwesomeIcon
                    icon={faPhone}
                    className='text-primary text-xl'
                  />
                  <p className='capitalize'>{responsable.telephone}</p>
                </div>
                <div className='flex gap-2 items-center'>
                  <FontAwesomeIcon
                    icon={faEnvelope}
                    className='text-primary text-xl'
                  />
                  <p className=''>{responsable.email}</p>
                </div>
              </div>
            </div>
          )}

          <div className='flex flex-col gap-3 lg:w-fit bg-primary bg-opacity-[0.07] p-6 rounded-lg'>
            <h2 className='font-medium'>Installations</h2>
            <div className='flex gap-7 text-[13px]'>
              <div className='flex gap-2 items-center'>
                <FontAwesomeIcon
                  icon={faLeaf}
                  className='text-primary text-xl'
                />
                <p className='lowercase'>{terrain.typeGazon}</p>
              </div>
              <div className='flex gap-2 items-center'>
                <FontAwesomeIcon
                  icon={faSun}
                  className='text-primary text-xl'
                />
                <p className='capitalize'>En Plein Air</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TerrainDetail;
