import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  const onSubmitHandler = async event => {
    event.preventDefault();
    setError('');
    setLoading(true);

    try {
      // Appel API pour le login
      const response = await axios.post(
        'http://localhost:8090/api/auth/login',
        {
          email: email.trim(),
          password,
        },
        {
          headers: { 'Content-Type': 'application/json' },
        }
      );

      console.log('Réponse backend :', response.data);

      const { token, role, id, nom, email: userEmail, telephone, ville, client } = response.data;

      // Stockage des données utilisateur
      localStorage.setItem('token', token);
      localStorage.setItem(
        'user',
        JSON.stringify({ id, nom, email: userEmail, role, telephone, ville, client })
      );

      // Redirection après connexion réussie
      navigate('/terrains');
      window.location.reload();
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
      className='min-h-[80vh] flex items-center'
    >
      <div className='flex flex-col gap-4 m-auto items-start p-8 min-w-[340px] sm:min-w-96 border rounded-xl text-zinc-600 text-sm shadow-lg'>
        <p className='text-2xl font-semibold'>Connexion</p>
        <p>Veuillez vous connecter pour accéder aux terrains.</p>
        {error && <p className='text-red-500 text-sm bg-red-100 p-2 rounded-md'>{error}</p>}
        <div className='w-full'>
          <label
            htmlFor='email'
            className='block text-sm font-medium'
          >
            Email
          </label>
          <input
            id='email'
            className='border border-zinc-300 rounded w-full p-2 mt-1'
            type='email'
            onChange={e => setEmail(e.target.value)}
            value={email}
            required
          />
        </div>
        <div className='w-full relative'>
          <label
            htmlFor='password'
            className='block text-sm font-medium'
          >
            Mot de passe
          </label>
          <input
            id='password'
            className='border border-zinc-300 rounded w-full p-2 mt-1'
            type={showPassword ? 'text' : 'password'}
            onChange={e => setPassword(e.target.value)}
            value={password}
            required
          />
          <button
            type='button'
            className='absolute top-[38px] right-2 text-gray-500 focus:outline-none'
            onClick={() => setShowPassword(!showPassword)}
          >
            {showPassword ? '🙈' : '👁️'}
          </button>
        </div>
        <button
          type='submit'
          className='bg-primary text-white w-full py-2 rounded-md'
          disabled={loading}
        >
          {loading ? 'Connexion en cours...' : 'Connexion'}
        </button>
        <p>
          Vous n'avez pas de compte ?{' '}
          <span className='text-primary underline cursor-pointer'>Inscrivez-vous ici</span>
        </p>
      </div>
    </form>
  );
};

export default Login;
