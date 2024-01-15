import React from 'react'
import { useState } from 'react';

const MyTableComponent = ({ data, count }) => {
    const [error, setError] = useState('');

    if (!data || data.length === 0) {
        return (
          <div>
            <p>No data available</p>
            <p>Total Calories for This Day: {count}</p>
          </div>
        );
      }
    console.log(data);
    return (
        <div>
          <h2>Meal Information</h2>
          <table>
            <thead>
              <tr>
                <th>Food Name</th>
                <th>Protein</th>
                <th>Carbohydrates</th>
                <th>Fats</th>
                <th>Calories</th>
                <th>Total Calories</th>
              </tr>
            </thead>
            <tbody>
              {data.map((meal, index) => (
                <tr key={index}>
                  <td>{meal.food.name}</td>
                  <td>{meal.food.protein}</td>
                  <td>{meal.food.carbohydrates}</td>
                  <td>{meal.food.fats}</td>
                  <td>{meal.food.calories}</td>
                  <td>{meal.totalCalories}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <p>Total Calories for This Day: {count}</p>
        </div>
      );
  };

export default MyTableComponent;
