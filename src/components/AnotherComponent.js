// AnotherComponent.js
import React from 'react';
import CustomApp from './App';

function AnotherComponent() {
  return (
    <div>
      {/* Use CustomApp instead of App */}
      <CustomApp />
    </div>
  );
}

export default AnotherComponent;
