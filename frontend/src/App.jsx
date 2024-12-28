import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Terrains from './pages/Terrains';
import Login from './pages/Login';
import About from './pages/About';
import Contact from './pages/Contact';
import MyProfile from './pages/MyProfile';
import MyBookings from './pages/MyBookings';
import Terrain from './pages/Terrain';
import Navbar from './components/Navbar';
import Footer from './components/Footer';

const App = () => {
  return (
    <div className='mx-4 sm:mx-[10%]'>
      <Navbar />
      <Routes>
        <Route
          path='/'
          element={<Home />}
        />
        <Route
          path='/terrains'
          element={<Terrains />}
        />
        <Route
          path='/terrains/:ville'
          element={<Terrains />}
        />
        <Route
          path='/login'
          element={<Login />}
        />
        <Route
          path='/about'
          element={<About />}
        />
        <Route
          path='/contact'
          element={<Contact />}
        />
        <Route
          path='/my-profile'
          element={<MyProfile />}
        />
        <Route
          path='/my-bookings'
          element={<MyBookings />}
        />
       <Route
  path='/terrain/:id' // Changez terrainId en id pour correspondre au nom utilisé
  element={<Terrain />}
/>
      </Routes>
      <Footer />
    </div>
  );
};

export default App;
