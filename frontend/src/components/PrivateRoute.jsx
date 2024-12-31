import React from 'react';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ element }) => {
  // Vérifiez si un token est stocké dans le localStorage
  const token = localStorage.getItem('token');

  // Si le token n'existe pas, redirigez vers la page de connexion
  if (!token) {
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
