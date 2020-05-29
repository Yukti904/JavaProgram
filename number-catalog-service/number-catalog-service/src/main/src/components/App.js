import React, {useEffect, useState} from 'react'; 
import Form from './Form'; 
import '../styles/App.css'; 
 
function App() {
  const [ welcomeMessage, setWelcomeMessage ] = useState(
    "Welcome to Numbers Trivia!",
  );
useEffect(() => {
    setTimeout(() => {
      setWelcomeMessage("Try Out Our Trivia Generator!");
    }, 3000);
  }, []);
return (
    <div className="App">
      <header className="App-header">
        <h1>{welcomeMessage}</h1>
      </header>
      <div id="result" style={{marginBottom: '15px'}}></div>
      <Form/>
    </div>
  );
}
export default App;