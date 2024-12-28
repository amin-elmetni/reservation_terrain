import React from 'react';
import Header from '../components/Header';
import VilleMenu from '@/components/VilleMenu';
import Banner from '@/components/Banner';
import TopTerrains from '@/components/TopTerrains';

const Home = () => {
  return (
    <div>
      <Header />
      <VilleMenu />
      <TopTerrains />
      <Banner />
    </div>
  );
};

export default Home;
