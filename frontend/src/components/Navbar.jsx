import React, { useState } from 'react';
import { assets } from '../assets/assets';
import { NavLink, useNavigate } from 'react-router-dom';
import { Button } from './ui/button';

const Navbar = () => {
  const navigate = useNavigate();

  const [showMenu, setShowMenu] = useState(false);
  const [token, setToken] = useState(true);

  return (
    <div className='flex items-center justify-between text-sm py-4 mb-5 border-b border-b-gray-400'>
      <img
        onClick={() => navigate('/')}
        className='cursor-pointer'
        src={assets.logo}
      />
      <ul className='hidden md:flex items-start gap-5 font-medium'>
        <NavLink to='/'>
          <li className='py-1 peer hover:scale-105 transition'>Home</li>
          <hr className='border-none outline-none h-0.5 bg-primary w-3/5 m-auto peer-hover:block peer-hover:bg-gray-300 hidden' />
        </NavLink>
        <NavLink to='/terrains'>
          <li className='py-1 peer hover:scale-105 transition'>Terrains</li>
          <hr className='border-none outline-none h-0.5 bg-primary w-3/5 m-auto peer-hover:block peer-hover:bg-gray-300 hidden' />
        </NavLink>
        <NavLink to='/about'>
          <li className='py-1 peer hover:scale-105 transition'>About</li>
          <hr className='border-none outline-none h-0.5 bg-primary w-3/5 m-auto peer-hover:block peer-hover:bg-gray-300 hidden' />
        </NavLink>
        <NavLink to='/contact'>
          <li className='py-1 peer hover:scale-105 transition'>Contact</li>
          <hr className='border-none outline-none h-0.5 bg-primary w-3/5 m-auto peer-hover:block peer-hover:bg-gray-300 hidden' />
        </NavLink>
      </ul>
      <div className='flex items-center gap-4'>
        {token ? (
          <div className='flex items-center gap-2 cursor-pointer group relative'>
            <img
              className='w-10 rounded-full border-2 bg-gray-200 group-hover:border-primary transition'
              src={assets.avatar}
              alt=''
            />
            <div className='absolute top-1 right-0 pt-14 text-base font-medium text-gray-600 z-20 hidden group-hover:block'>
              <div className='min-w-48 bg-stone-100 rounded flex flex-col gap-4 p-4'>
                <p
                  onClick={() => navigate('my-profile')}
                  className='hover:text-primary cursor-pointer'
                >
                  My profile
                </p>
                <p
                  onClick={() => navigate('my-bookings')}
                  className='hover:text-primary cursor-pointer'
                >
                  My bookings
                </p>
                <p
                  onClick={() => setToken(false)}
                  className='hover:text-primary cursor-pointer'
                >
                  Logout
                </p>
              </div>
            </div>
          </div>
        ) : (
          <button
            onClick={() => navigate('/login')}
            className='bg-primary text-white px-8 py-3 rounded-full font-light hidden md:block'
          >
            Créer Compte
          </button>
        )}
      </div>
    </div>
  );
};

export default Navbar;
