import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const Terrain = () => {
  const { id } = useParams(); // ID du terrain
  const [terrain, setTerrain] = useState(null);
  const [loading, setLoading] = useState(true);
  const [matchDetails, setMatchDetails] = useState({
    dateMatch: null,
    heureMatch: "",
  });
  const [matchCreated, setMatchCreated] = useState(null);
  const [reservationDone, setReservationDone] = useState(false);

  // Récupérer le token depuis localStorage
  const token = localStorage.getItem("token");

  // Configuration des en-têtes avec le token
  const axiosConfig = {
    headers: {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    },
  };

  const fetchTerrain = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8090/api/terrains/${id}`,
        axiosConfig
      );
      setTerrain(response.data);
    } catch (error) {
      console.error("Erreur lors de la récupération du terrain :", error);
    } finally {
      setLoading(false);
    }
  };

  const handleMatchCreation = async () => {
    if (!matchDetails.dateMatch || !matchDetails.heureMatch) {
      alert("Veuillez définir une date et une heure pour le match.");
      return;
    }

    try {
      const user = JSON.parse(localStorage.getItem("user"));

      // Formater `dateMatch` et `heureMatch`
      const formattedDate = matchDetails.dateMatch.toISOString(); // yyyy-MM-ddTHH:mm:ss
      const formattedTime = matchDetails.heureMatch; // Exemple: "14:00"

      const matchData = {
        clientId: user.id,
        terrainId: parseInt(id, 10),
        dateMatch: formattedDate,
        heureMatch: formattedTime,
      };

      console.log("Données envoyées pour créer le match :", matchData);

      // Créer le match
      const matchResponse = await axios.post(
        "http://localhost:8090/api/matches",
        matchData,
        axiosConfig
      );

      setMatchCreated(matchResponse.data);
      console.log("Match créé avec succès :", matchResponse.data);

      // Réserver le terrain pour le match
      const reservationResponse = await axios.post(
        "http://localhost:8090/api/reservations",
        {
          matchId: matchResponse.data.id, // ID du match créé
        },
        axiosConfig
      );

      setReservationDone(true);
      alert("Match créé et terrain réservé avec succès !");
    } catch (error) {
      console.error(
        "Erreur lors de la création du match ou de la réservation :",
        error.response || error.message
      );
      alert(
        error.response?.data?.message ||
          "Erreur lors de la création du match ou de la réservation."
      );
    }
  };

  useEffect(() => {
    fetchTerrain();
  }, [id]);

  if (loading) {
    return (
      <div className="flex justify-center items-center h-screen">
        <p className="text-lg font-medium text-gray-600">
          Chargement des détails du terrain...
        </p>
      </div>
    );
  }

  if (!terrain) {
    return (
      <div className="flex justify-center items-center h-screen">
        <p className="text-lg font-medium text-gray-600">Terrain introuvable.</p>
      </div>
    );
  }

  return (
    <div className="max-w-5xl mx-auto p-8 bg-white shadow-lg rounded-lg">
      <h1 className="text-4xl font-extrabold text-primary mb-8 text-center">
        {terrain.nom}
      </h1>
      <div className="flex flex-col lg:flex-row gap-8">
        <img
          src={terrain.imageUrl}
          alt={terrain.nom}
          className="w-full lg:w-2/3 h-80 object-cover rounded-lg shadow-lg"
        />
        <div className="flex flex-col gap-6 bg-gray-50 p-6 rounded-lg shadow-md">
          <p className="text-lg font-medium text-gray-700">
            <span className="font-bold text-gray-900">Ville : </span>
            {terrain.ville}
          </p>
          <p className="text-lg font-medium text-gray-700">
            <span className="font-bold text-gray-900">Capacité : </span>
            {terrain.capacite} joueurs
          </p>
          <p className="text-lg font-medium text-gray-700">
            <span className="font-bold text-gray-900">Type de gazon : </span>
            {terrain.typeGazon}
          </p>
        </div>
      </div>

      <div className="mt-8 bg-gray-100 p-6 rounded-lg shadow-md">
        <h2 className="text-xl font-semibold mb-4">Créer un match</h2>
        <div className="flex flex-col sm:flex-row gap-4">
          <DatePicker
            selected={matchDetails.dateMatch}
            onChange={(date) =>
              setMatchDetails({ ...matchDetails, dateMatch: date })
            }
            dateFormat="yyyy-MM-dd"
            className="border border-gray-300 rounded p-2 w-full"
            placeholderText="Choisissez une date"
          />
          <select
            value={matchDetails.heureMatch}
            onChange={(e) =>
              setMatchDetails({ ...matchDetails, heureMatch: e.target.value })
            }
            className="border border-gray-300 rounded p-2 w-full"
          >
            <option value="">Choisissez une heure</option>
            {["10:00", "12:00", "14:00", "16:00", "18:00"].map((hour) => (
              <option key={hour} value={hour}>
                {hour}
              </option>
            ))}
          </select>
        </div>
        <button
          onClick={handleMatchCreation}
          className="mt-4 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          Créer le match et réserver
        </button>
      </div>
    </div>
  );
};

export default Terrain;