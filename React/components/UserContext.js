// UserContext.js
import { createContext, useContext, useState } from 'react';

const UserContext = createContext();

export const UserProvider = ({ children,initialName }) => {
  const [userName, setLoggedUsername] = useState(initialName || '');

  return (
    <UserContext.Provider value={{ userName:userName, setLoggedUsername }}>
      {children}
    </UserContext.Provider>
  );
};

export const useUser = () => {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error('useUser must be used within a UserProvider');
  }
  return context;
};

export default UserProvider;