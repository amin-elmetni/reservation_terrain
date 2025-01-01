import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { FaUserCircle } from 'react-icons/fa';
import { FiEdit } from 'react-icons/fi';
import { MdSportsSoccer } from 'react-icons/md';

const villesEnum = ['CASABLANCA', 'RABAT', 'MARRAKECH', 'TANGER', 'FES', 'AGADIR', 'TETOUAN'];

const MyProfile = () => {
  const [user, setUser] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState({});
  const [popupMessage, setPopupMessage] = useState(null);

  useEffect(() => {
    const userData = localStorage.getItem('user');
    if (userData) {
      const parsedData = JSON.parse(userData);
      setUser(parsedData);
      setFormData({
        nom: parsedData.nom,
        email: parsedData.email,
        telephone: parsedData.telephone,
        ville: parsedData.ville,
        password: '',
      });
    }
  }, []);

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleUpdate = async e => {
    e.preventDefault();

    try {
      const response = await axios.put(
        `http://localhost:8090/api/utilisateurs/${user.id}`,
        formData,
        {
          headers: { 'Content-Type': 'application/json' },
        }
      );

      const updatedUser = response.data;

      localStorage.setItem('user', JSON.stringify(updatedUser));
      setUser(updatedUser);
      setPopupMessage({ type: 'success', text: 'Mise à jour réussie !' });
      setIsEditing(false);
    } catch (error) {
      console.error('Erreur lors de la mise à jour :', error);
      setPopupMessage({
        type: 'error',
        text: 'Erreur lors de la mise à jour. Veuillez réessayer.',
      });
    } finally {
      setTimeout(() => setPopupMessage(null), 3000);
    }
  };

  const getInitial = name => (name ? name.charAt(0).toUpperCase() : '?');

  if (!user) {
    return (
      <div className='min-h-screen flex justify-center items-center text-lg'>Chargement...</div>
    );
  }

  return (
    <div>
      {/* Popup Message */}
      {popupMessage && (
        <div
          className={`fixed top-4 left-1/2 transform -translate-x-1/2 px-6 py-3 rounded-lg text-white shadow-lg ${
            popupMessage.type === 'success' ? 'bg-green-500' : 'bg-red-500'
          }`}
        >
          {popupMessage.text}
        </div>
      )}

      <div className='flex flex-col justify-center items-center h-full'>
        <div className='bg-white shadow-lg border rounded-3xl w-full sm:w-96 p-6 flex flex-col items-center text-center gap-2'>
          {!isEditing ? (
            <>
              <div className='bg-gray-200 text-blue-500 rounded-full w-32 h-32 flex items-center justify-center text-4xl font-bold mb-6'>
                <FaUserCircle size={64} />
              </div>
              <h1 className='text-2xl font-semibold mb-2'>{user.nom}</h1>
              <p className='text-gray-600 mb-1'>
                <strong>Email :</strong> {user.email}
              </p>
              <p className='text-gray-600 mb-1'>
                <strong>Téléphone :</strong> {user.telephone}
              </p>
              <p className='text-gray-600 mb-1'>
                <strong>Ville :</strong> {user.ville}
              </p>
              <p className='text-sm text-blue-500 font-medium px-3 py-1 bg-blue-100 rounded-full'>
                {user.role}
              </p>
              <button
                className='mt-6 bg-blue-500 text-white px-4 py-2 rounded-md flex items-center gap-2 hover:bg-blue-600'
                onClick={() => setIsEditing(true)}
              >
                <FiEdit /> Modifier
              </button>
            </>
          ) : (
            <form
              onSubmit={handleUpdate}
              className='w-full text-left'
            >
              <h2 className='text-xl font-semibold text-center mb-4'>Modifier Profil</h2>
              <div className='mb-4'>
                <label className='block text-sm font-medium'>Nom</label>
                <input
                  type='text'
                  name='nom'
                  value={formData.nom}
                  onChange={handleChange}
                  className='border border-gray-300 rounded w-full p-2'
                />
              </div>
              <div className='mb-4'>
                <label className='block text-sm font-medium'>Email</label>
                <input
                  type='email'
                  name='email'
                  value={formData.email}
                  onChange={handleChange}
                  className='border border-gray-300 rounded w-full p-2'
                />
              </div>
              <div className='mb-4'>
                <label className='block text-sm font-medium'>Téléphone</label>
                <input
                  type='text'
                  name='telephone'
                  value={formData.telephone}
                  onChange={handleChange}
                  className='border border-gray-300 rounded w-full p-2'
                />
              </div>
              <div className='mb-4'>
                <label className='block text-sm font-medium'>Ville</label>
                <select
                  name='ville'
                  value={formData.ville}
                  onChange={handleChange}
                  className='border border-gray-300 rounded w-full p-2'
                >
                  <option value=''>Sélectionnez une ville</option>
                  {villesEnum.map(ville => (
                    <option
                      key={ville}
                      value={ville}
                    >
                      {ville}
                    </option>
                  ))}
                </select>
              </div>
              <div className='mb-4'>
                <label className='block text-sm font-medium'>Mot de passe</label>
                <input
                  type='password'
                  name='password'
                  value={formData.password}
                  onChange={handleChange}
                  className='border border-gray-300 rounded w-full p-2'
                  placeholder='Laissez vide pour ne pas modifier'
                />
              </div>
              <div className='flex justify-end gap-4'>
                <button
                  type='button'
                  className='bg-gray-500 text-white px-4 py-2 rounded-md hover:bg-gray-600'
                  onClick={() => setIsEditing(false)}
                >
                  Annuler
                </button>
                <button
                  type='submit'
                  className='bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600'
                >
                  Enregistrer
                </button>
              </div>
            </form>
          )}
        </div>
      </div>
    </div>
  );
};

export default MyProfile;
