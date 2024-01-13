import logo from './logo.svg';
import './App.css';

import React from 'react';
import UserComponent from './components/UserComponent';
import UserService from './components/UserService';
import EnterCalories from './components/EnterCalories'


import {
  BrowserRouter as Router,
  Route,
  Link,
  Routes,
} from 'react-router-dom';

import LoginForm from './components/SignUp'
import { UserProvider } from './components/UserContext';
import MyTableComponent from './components/MyTableComponent';

const App = () => {
  return (
    <Router>
       <UserProvider>
    <Routes>
      <Route path="/LoginForm" element={<LoginForm />} />
      <Route path="/EnterCalories" element={<EnterCalories />}/>
      <Route path="/Logged" element={<UserComponent />} />
      
    </Routes>
  </UserProvider>
  </Router>
  );
};



export default App;
