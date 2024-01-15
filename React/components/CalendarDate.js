import React, { useEffect, useState ,useCallback} from 'react';

const CalendarApp = ({onDateChange}) => {
  const [currentDate, setCurrentDate] = useState(new Date());

  const formatDate = (date) => {
    const day = date.getDate();
    const month = date.getMonth() + 1; // Months are zero-based
    const year = date.getFullYear();

    const formattedMonth = month < 10 ? `0${month}` : `${month}`;
    const formattedDay = day < 10 ? `0${day}` : `${day}`;

    return `${year}-${formattedMonth}-${formattedDay}`;
  };

  const decrementDate = () => {
    const newDate = new Date(currentDate);
    newDate.setDate(currentDate.getDate() - 1);
    setCurrentDate(newDate);
  };

  const incrementDate = () => {
    const newDate = new Date(currentDate);
    newDate.setDate(currentDate.getDate() + 1);
    setCurrentDate(newDate);
  };

  const memoizedOnDateChange = useCallback(() => {
    onDateChange(formatDate(currentDate));
  }, [currentDate, onDateChange]);


  useEffect(() => {
    memoizedOnDateChange();
  }, [memoizedOnDateChange]);

  return (
    <div>
      <button className ='button'onClick={decrementDate}>Previous Day</button>
      <button className ='button'onClick={incrementDate}>Next Day</button>

      <div>
        <strong>Selected Date:</strong> {formatDate(currentDate)}
      </div>

      <div>
        {/* Here you can fetch and display data for the selected date */}
        {/* Replace this with your actual data-fetching logic */}
        <strong>Data Display:</strong> Data for {formatDate(currentDate)}
      </div>
    </div>
  );
};

export default CalendarApp;
