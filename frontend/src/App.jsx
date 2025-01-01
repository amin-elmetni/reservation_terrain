import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Terrains from './pages/Terrains';
import Login from './pages/Login';
import MyProfile from './pages/MyProfile';
import MesReservations from './pages/MesReservations';
import Terrain from './pages/Terrain';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import PrivateRoute from './components/PrivateRoute'; // Importer PrivateRoute
import Signup from './pages/Signup';

const App = () => {
  return (
    <div className='mx-4 sm:mx-[6%]'>
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
          path='/mon-profil'
          element={<PrivateRoute element={<MyProfile />} />}
        />
        <Route
          path='/mes-reservations'
          element={<PrivateRoute element={<MesReservations />} />}
        />
        <Route
          path='/signup'
          element={<Signup />}
        />
        <Route
          path='/terrain/:id'
          element={<PrivateRoute element={<Terrain />} />}
        />
      </Routes>
      <Footer />
    </div>
  );
};

export default App;
