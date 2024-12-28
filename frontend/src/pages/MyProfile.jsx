import React, { useEffect, useState } from 'react';

const MyProfile = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const userData = localStorage.getItem('user');
    if (userData) {
      setUser(JSON.parse(userData));
    }
  }, []);

  const getInitial = (name) => {
    return name ? name.charAt(0).toUpperCase() : '?';
  };

  if (!user) {
    return (
      <div className="min-h-screen flex justify-center items-center text-lg">
        Chargement...
      </div>
    );
  }

  return (
    <div className="min-h-screen flex flex-col justify-center items-center bg-100">
      <div className="bg-white shadow-lg rounded-3xl w-full sm:w-96 p-6 flex flex-col items-center text-center">
        {/* Icône circulaire avec initiale */}
        <div className="bg-blue-500 text-white rounded-full w-32 h-32 flex items-center justify-center text-4xl font-bold mb-6">
          {getInitial(user.nom)}
        </div>

        {/* Informations utilisateur */}
        <h1 className="text-2xl font-semibold mb-2">{user.nom}</h1>
        <p className="text-gray-600 mb-1">
          <strong>Email :</strong> {user.email}
        </p>
        <p className="text-gray-600 mb-1">
          <strong>Téléphone :</strong> {user.telephone}
        </p>
        <p className="text-gray-600 mb-1">
          <strong>Ville :</strong> {user.ville}
        </p>
        <p className="text-sm text-blue-500 font-medium px-3 py-1 bg-blue-100 rounded-full">
          {user.role}
        </p>

        {/* Informations Client (si disponibles) */}
        {user.client && (
          <div className="mt-6 w-full text-left">
            <h2 className="text-lg font-semibold text-gray-700 mb-2">
              Données Client
            </h2>
            <p className="text-gray-600">
              <strong>ID Client :</strong> {user.client.id}
            </p>
            <p className="text-gray-600">
              <strong>Type Client :</strong> {user.client.typeClient}
            </p>
            {user.client.nomOrganisation && (
              <p className="text-gray-600">
                <strong>Organisation :</strong> {user.client.nomOrganisation}
              </p>
            )}
          </div>
        )}
      </div>
    </div>
  );
};

export default MyProfile;