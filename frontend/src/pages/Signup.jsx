import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Swal from 'sweetalert2';
import api from '@/api';

const villesEnum = ['CASABLANCA', 'RABAT', 'MARRAKECH', 'TANGER', 'FES', 'AGADIR', 'TETOUAN'];

const Signup = () => {
  const [formData, setFormData] = useState({
    nom: '',
    email: '',
    password: '',
    confirmPassword: '',
    telephone: '',
    ville: '',
    role: 'CLIENT',
  });

  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const navigate = useNavigate();

  const onChangeHandler = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const onSubmitHandler = async event => {
    event.preventDefault();
    setError('');

    if (formData.password !== formData.confirmPassword) {
      setError('Les mots de passe ne correspondent pas.');
      return;
    }

    setLoading(true);

    try {
      const response = await api.post('/api/utilisateurs', formData, {
        headers: { 'Content-Type': 'application/json' },
      });

      console.log('Réponse backend :', response.data);
      Swal.fire({
        title: 'Inspcrition Complete',
        text: 'Compte créé avec succès ! Veuillez vous connecter.',
        icon: 'success',
        confirmButtonText: 'OK',
        timer: 3000,
      }).then(() => {
        navigate('/login');
      });
    } catch (error) {
      console.error('Erreur API :', error.response || error.message);
      setError(error.response?.data?.message || 'Une erreur est survenue. Veuillez réessayer.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <form
      onSubmit={onSubmitHandler}
      className=' flex flex-col justify-center items-center bg-white-100 px-4 transform mt-6 '
    >
      <div className='bg-white shadow-lg rounded-lg p-8 max-w-3xl w-full border'>
        <h2 className='text-2xl font-semibold text-center mb-4 text-gray-800'>Inscription</h2>
        <p className='text-center text-gray-600 mb-6'>Créez un compte pour accéder aux terrains.</p>
        {error && (
          <p className='text-red-500 text-sm bg-red-100 p-2 rounded-md mb-4 text-center'>{error}</p>
        )}
        <div className='grid grid-cols-1 md:grid-cols-2 gap-6'>
          <div>
            <label className='block text-sm font-medium text-gray-700'>Nom complet</label>
            <input
              id='nom'
              name='nom'
              className='border border-gray-300 rounded w-full p-3 mt-1 placeholder-gray-400'
              type='text'
              placeholder='Votre nom complet'
              onChange={onChangeHandler}
              value={formData.nom}
              required
            />
          </div>
          <div>
            <label className='block text-sm font-medium text-gray-700'>Email</label>
            <input
              id='email'
              name='email'
              className='border border-gray-300 rounded w-full p-3 mt-1 placeholder-gray-400'
              type='email'
              placeholder='Votre adresse email'
              onChange={onChangeHandler}
              value={formData.email}
              required
            />
          </div>
          <div>
            <label className='block text-sm font-medium text-gray-700'>Téléphone</label>
            <input
              id='telephone'
              name='telephone'
              className='border border-gray-300 rounded w-full p-3 mt-1 placeholder-gray-400'
              type='text'
              placeholder='Votre numéro de téléphone'
              onChange={onChangeHandler}
              value={formData.telephone}
              required
            />
          </div>
          <div>
            <label className='block text-sm font-medium text-gray-700'>Ville</label>
            <select
              id='ville'
              name='ville'
              className='border border-gray-300 rounded w-full p-3 mt-1 text-gray-500'
              onChange={onChangeHandler}
              value={formData.ville}
              required
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
          <div className='relative'>
            <label className='block text-sm font-medium text-gray-700'>Mot de passe</label>
            <input
              id='password'
              name='password'
              className='border border-gray-300 rounded w-full p-3 mt-1 placeholder-gray-400'
              type={showPassword ? 'text' : 'password'}
              placeholder='Votre mot de passe'
              onChange={onChangeHandler}
              value={formData.password}
              required
            />
            <button
              type='button'
              className='absolute top-[42px] right-2 text-gray-500 focus:outline-none'
              onClick={() => setShowPassword(!showPassword)}
            >
              {showPassword ? '🙈' : '👁️'}
            </button>
          </div>
          <div className='relative'>
            <label className='block text-sm font-medium text-gray-700'>
              Confirmer le mot de passe
            </label>
            <input
              id='confirmPassword'
              name='confirmPassword'
              className='border border-gray-300 rounded w-full p-3 mt-1 placeholder-gray-400'
              type={showConfirmPassword ? 'text' : 'password'}
              placeholder='Confirmez votre mot de passe'
              onChange={onChangeHandler}
              value={formData.confirmPassword}
              required
            />
            <button
              type='button'
              className='absolute top-[42px] right-2 text-gray-500 focus:outline-none'
              onClick={() => setShowConfirmPassword(!showConfirmPassword)}
            >
              {showConfirmPassword ? '🙈' : '👁️'}
            </button>
          </div>
        </div>
        <button
          type='submit'
          className='bg-primary text-white w-full py-3 rounded-md mt-6'
          disabled={loading}
        >
          {loading ? 'Inscription en cours...' : 'S’inscrire'}
        </button>
        <p className='text-center mt-4 text-gray-600'>
          Vous avez déjà un compte ?{' '}
          <span
            className='text-primary underline cursor-pointer'
            onClick={() => {
              navigate('/login');
              scrollTo(0, 0);
            }}
          >
            Connectez-vous ici
          </span>
        </p>
      </div>
    </form>
  );
};

export default Signup;
