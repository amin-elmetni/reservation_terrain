import React from 'react';
import { assets } from '../assets/assets';

const Footer = () => {
  return (
    <div className='md:mx-10'>
      <div className='flex flex-col sm:grid grid-cols-[3fr_1fr_1fr] gap-14 my-10 mt-40 text-sm'>
        {/* //* ----------- Left Section -----------  */}
        <div>
          <img
            className='mb-5 w-40'
            src={assets.logo}
          />
          <p className='w-full md:w-2/3 text-gray-600 leading-6'>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel, dolor! Voluptatibus sed
            veritatis enim incidunt facilis magnam alias nulla et obcaecati accusantium veniam,
            odio, expedita dicta suscipit quasi saepe corrupti?
          </p>
        </div>

        {/* //* ----------- Center Section -----------  */}
        <div>
          <p className='text-xl font-medium mb-5'>Entreprise</p>
          <ul className='flex flex-col gap-2 text-gray-600'>
            <li>Home</li>
            <li>About us</li>
            <li>Contact us</li>
            <li>Privacy policy</li>
          </ul>
        </div>

        {/* //* ----------- Right Section -----------  */}
        <div>
          <p className='text-xl font-medium mb-5'>CONTACT</p>
          <ul className='flex flex-col gap-2 text-gray-600'>
            <li>+212-694-399-071</li>
            <li>amin.elmetni@gmail.com</li>
          </ul>
        </div>
      </div>

      {/* //* ----------- Copyright Text -----------  */}
      <div>
        <hr />
        <p className='py-5 text-sm text-center'>Copyright 2024@ Prescripto - All Right REserved.</p>
      </div>
    </div>
  );
};

export default Footer;
