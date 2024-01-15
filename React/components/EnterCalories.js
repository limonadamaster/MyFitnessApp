import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useUser } from './UserContext';
import MyTableComponent from './MyTableComponent';
import CalendarApp from './CalendarDate';

const EnterCalories = () => {
  const { userName } = useUser();
  const [foodName, setFoodName] = useState('');
  const [servingSize, setServingSize] = useState(0);
  const [foodOptions, setFoodOptions] = useState([]);
  const [selectedOption, setSelectedOption] = useState('');
  const [mealData, setMealData] = useState({ mealList: [], totalCalories: 0 });

  // Initialize formattedDate with a default value or the current date
  const [formattedDate, setFormattedDate] = useState(/* default or current date */);

  const fetchMealData = (formattedDate) => {

    if (formattedDate !== previousDate) {
      console.log(userName, formattedDate);

      axios.get(`http://localhost:8000/calories/${userName}/${formattedDate}`)
        .then(response => {
          const data = response.data;
          setMealData(data);
          setPreviousDate(formattedDate);
          //console.log(formattedDate);
        })
        .catch(error => {
          console.error("Error fetching data!", error);
        });
    }

  };



  const [previousDate, setPreviousDate] = useState('');

  useEffect(() => {
    axios.get("http://localhost:8000/food/getAll")
      .then((response) => {
        setFoodOptions(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const enterCalories = () => {
    // Add logic to send data to Spring Boot API

    axios.post('http://localhost:8000/calories/add', { userName, foodName, servingSize })
      .then((response) => {
        console.log('Calories added successfully');
        console.log(userName);
        // After adding calories, fetch updated meal data for the current date
        fetchMealData(formattedDate);
      })
      .catch((error) => {
        console.error('Error adding calories:', error);
        console.log(selectedOption);
      });
  };

  // TODO Make combobox to select foods !!
  const handleSelectChange = (e) => {
    setSelectedOption(e.target.value);
    setFoodName(e.target.value);
  };

  const handleDateChange = (newDate) => {
    setFormattedDate(newDate);
    // Fetch meal data when the date changes
    fetchMealData(newDate);
  };

  return (
    <div className="colorie-container">
      <label>Foods
        <div>
          <select value={selectedOption} onChange={handleSelectChange}>
            {foodOptions.map((option) => (
              <option key={option.id} value={option.name}>
                {option.name}
              </option>
            ))}
          </select>
        </div>
      </label>
      <div>
        <label>Serving Size: <input type="text" value={servingSize} onChange={(e) => setServingSize(e.target.value)} /></label>
      </div>
      <div>
        <button onClick={enterCalories}>Set Calories</button>
      </div>

      {<MyTableComponent data={mealData.mealList} count={mealData.totalCaloriesForThisDay} />}
      <CalendarApp onDateChange={handleDateChange} />
    </div>
  );
};

export default EnterCalories;
