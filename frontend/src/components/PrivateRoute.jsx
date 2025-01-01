import React from 'react';
import { Navigate, useLocation } from 'react-router-dom';

const PrivateRoute = ({ element }) => {
  // Vérifiez si un token est stocké dans le localStorage
  const token = localStorage.getItem('token');
  const location = useLocation();

  // Si le token n'existe pas, redirigez vers la page de connexion
  if (!token) {
    localStorage.setItem('lastVisited', location.pathname);
    return (
      <Navigate
        to='/login'
        replace
      />
    );
  }

  // Si le token existe, autorisez l'accès à la page demandée
  return element;
};

export default PrivateRoute;
