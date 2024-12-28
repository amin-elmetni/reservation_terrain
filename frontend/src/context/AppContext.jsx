import { createContext, createCotext } from 'react';
import { terrainsData } from '@/assets/assets';

export const AppContext = createContext();

const AppContextProvider = props => {
  const value = {
    terrainsData,
  };

  return <AppContext.Provider value={value}>{props.children}</AppContext.Provider>;
};

export default AppContextProvider;
