import React, { useState } from 'react';
import axios from 'axios';
import EnterCalories from './EnterCalories';
import { UserProvider } from './UserContext';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = () => {
    axios.post('http://localhost:8000/user/login', { username, password })
      .then(() => {
        setLoggedIn(true);
        console.log('Sending data to API:', { username, password });
      })
      .catch((error) => {
        console.error('Error during login:', error);
      });
  };

  return (
    <div className="login-container">
      {!loggedIn ? (
        <div>
          {/* Your login form JSX */}
          <label>
            Username: <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
          </label>
          <div />
          <label>
            Password: <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
          </label>
          <div>
            <button onClick={handleLogin}>Login</button>
          </div>
        </div>
      ) : (
        <UserProvider initialName={username}>
          <EnterCalories />
        </UserProvider>
      )}
    </div>
  );
};

export default LoginForm;
