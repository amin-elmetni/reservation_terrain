import logo from './logo.svg';
import avatar from './avatar.png';
import group_profiles from './group_profiles.png';
import header from './header.png';
import banner from './banner.png';

import tetouan from './villes/tetouan.png';
import tanger from './villes/tanger.png';
import casablanca from './villes/casablanca.png';
import rabat from './villes/rabat.png';
import merrakech from './villes/merrakech.png';
import fes from './villes/fes.png';
import agadir from './villes/agadir.png';

import limpica from './terrains/limpica.png';
import stadium_rabat from './terrains/stadium_rabat.png';
import ocean_agadir from './terrains/ocean_agadir.png';

export const assets = {
  logo,
  avatar,
  group_profiles,
  header,
  banner,
  limpica
};

// * Villes : Tetouan, Tanger, Casablanca, Rabat, Merrakech, Fes, Agadir
export const villesData = [
  {
    ville: 'TETOUAN',
    image: tetouan,
  },
  {
    ville: 'TANGER',
    image: tanger,
  },
  {
    ville: 'CASABLANCA',
    image: casablanca,
  },
  {
    ville: 'RABAT',
    image: rabat,
  },
  {
    ville: 'MARRAKECH',
    image: merrakech,
  },
  {
    ville: 'FES',
    image: fes,
  },
  {
    ville: 'AGADIR',
    image: agadir,
  },
];

// * Terrain : image, nom, addresse, localisation, disponibilité, capacité, ville, type_gazon, responsable
export const terrainsData = [
  {
    id: 1,
    image: limpica,
    nom: 'Limpica',
    addresse: 'Tetouan Jammae Mezouak Av Mamoun',
    localisation: '35.68, -5.67',
    disponibilite: true,
    capacite: '10',
    ville: 'Tetouan',
    type_gazon: 'naturelle',
    responsable: 'Mohamed Amin El Metni',
  },
  {
    id: 2,
    image: stadium_rabat,
    nom: 'Stadium Rabat',
    addresse: 'Avenue Hassan II, Rabat',
    localisation: '34.02, -6.83',
    disponibilite: false,
    capacite: '15',
    ville: 'Rabat',
    type_gazon: 'synthétique',
    responsable: 'Karim Ait Lahcen',
  },
  {
    id: 3,
    image: ocean_agadir,
    nom: 'Ocean Agadir',
    addresse: 'Boulevard Mohammed V, Agadir',
    localisation: '30.42, -9.60',
    disponibilite: true,
    capacite: '12',
    ville: 'Agadir',
    type_gazon: 'naturelle',
    responsable: 'Fatima Zahra Bouziane',
  },
  {
    id: 4,
    image: 'green_marrakech',
    nom: 'Green Marrakech',
    addresse: 'Route de l’Ourika, Marrakech',
    localisation: '31.62, -7.99',
    disponibilite: true,
    capacite: '8',
    ville: 'Marrakech',
    type_gazon: 'hybride',
    responsable: 'Youssef Ben Jilali',
  },
  {
    id: 5,
    image: 'champion_casablanca',
    nom: 'Stad Casablanca',
    addresse: 'Quartier Maarif, Casablanca',
    localisation: '33.57, -7.62',
    disponibilite: false,
    capacite: '20',
    ville: 'Casablanca',
    type_gazon: 'synthétique',
    responsable: 'Hassan El Mansouri',
  },
  {
    id: 6,
    image: 'atlas_fes',
    nom: 'Atlas Fes',
    addresse: 'Boulevard Allal Al Fassi, Fes',
    localisation: '34.03, -4.99',
    disponibilite: true,
    capacite: '10',
    ville: 'Fes',
    type_gazon: 'naturelle',
    responsable: 'Salma Idrissi',
  },
  {
    id: 7,
    image: 'star_tanger',
    nom: 'Star Tanger',
    addresse: 'Avenue Mohamed VI, Tanger',
    localisation: '35.78, -5.82',
    disponibilite: true,
    capacite: '18',
    ville: 'Tanger',
    type_gazon: 'synthétique',
    responsable: 'Rachid El Faris',
  },
  {
    id: 8,
    image: 'oasis_kenitra',
    nom: 'Oasis Kenitra',
    addresse: 'Route de Meknès, Kenitra',
    localisation: '34.26, -6.57',
    disponibilite: false,
    capacite: '14',
    ville: 'Kenitra',
    type_gazon: 'naturelle',
    responsable: 'Amina Chrif',
  },
  {
    id: 9,
    image: 'heritage_meknes',
    nom: 'Heritage Meknes',
    addresse: 'Place El-Hedim, Meknès',
    localisation: '33.89, -5.56',
    disponibilite: true,
    capacite: '12',
    ville: 'Meknès',
    type_gazon: 'hybride',
    responsable: 'Ahmed El Kharroubi',
  },
  {
    id: 10,
    image: 'palm_marrakech',
    nom: 'Palm Marrakech',
    addresse: 'Palmeraie de Marrakech, Marrakech',
    localisation: '31.64, -8.01',
    disponibilite: true,
    capacite: '10',
    ville: 'Marrakech',
    type_gazon: 'naturelle',
    responsable: 'Khalid El Wazir',
  },
  {
    id: 11,
    image: 'medina_rabat',
    nom: 'Medina Rabat',
    addresse: 'Rue des Consuls, Rabat',
    localisation: '34.02, -6.83',
    disponibilite: false,
    capacite: '15',
    ville: 'Rabat',
    type_gazon: 'synthétique',
    responsable: 'Nadia Bouazza',
  },
];
