import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {useUser} from './UserContext'
import MyTableComponent from './MyTableComponent';

const EnterCalories = () => {
  const {userName} =useUser();
  const [foodName, setFoodName] = useState('');
  const [servingSize, setServingSize] = useState(0);
   const [foodOptions, setFoodOptions] = useState([]);
  const [selectedOption, setSelectedOption] = useState('');
  const [mealData,setMealData] = useState({mealList:[],totalCalories:0});

  useEffect(()=>{
    const fetchMealData=async()=>{
      try{
        const respone = await axios.get(`http://localhost:8000/calories/${userName}`);
        const data = respone.data;
        setMealData(data);
        console.log(mealData);
      }catch(error){
        console.error("error fetching data!",error);
      }
    }
  fetchMealData();
  },[userName]);
  
  useEffect(() => {
    console.log("Updated mealData:", mealData);
  }, [mealData]);
  
  useEffect(()=>{
    axios.get("http://localhost:8000/food/getAll")
    .then((response)=>{
        setFoodOptions(response.data);
    })
    .catch((error)=>{
      console.log(error);
    });
  },[]);
  
  const enterCalories = () => {
    // Add logic to send data to Spring Boot API
    
    axios.post('http://localhost:8000/calories/add', {userName, foodName, servingSize })
      .then((response) => {
        console.log('Calories added successfully');
        console.log(userName);
      })
      .catch((error) => {
       console.error('Error adding calories:', error);
       console.log(selectedOption);

      });
  };


//TODO Make combobox to select foods !!
  const handleSelectChange = (e) => {
    setSelectedOption(e.target.value);
    setFoodName(e.target.value);
  };

  return (
    <div className="colorie-container">
     <label>Foods<div>
       
        <select  value={selectedOption} onChange={handleSelectChange}>

      {foodOptions.map((option)=>(
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

     
{<MyTableComponent data={mealData.mealList} count={mealData.totalCaloriesForThisDay}/>}

    </div>
  );
};

export default EnterCalories;
