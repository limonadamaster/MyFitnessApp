// src/components/PersonList.js

import React, { useEffect, useState } from 'react';

const PersonList = () => {
  const [persons, setPersons] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('/getperson');
        const data = await response.json();
        setPersons(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h2>Persons List</h2>
      <ul>
        {persons.map(person => (
          <li key={person.id}>
            {person.firstName} {person.lastName}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PersonList;
