import React, { useState } from 'react';
function Form(props){
  let [number, setNumber] = useState("random");
  let [type, setType] = useState("trivia");
  function onNumberChanged(e){
    let value = e.target.value.trim();
    if(!value.length){
      setNumber("random"); //default value
    } else {
      setNumber(value);
    }
  }
  function onSubmit(e){
    e.preventDefault();
    axios.get('http://numbersapi.com/' + number + '/' + type)
         .then(function(response){
           let elm = document.getElementById('result');
           elm.innerHTML = response.data;
         }).catch(function(e){
           console.log("error", e); //simple error handling
         });
  }
  }
  return (<form>
            <div>
              <input type="text" name="number" placeholder="Enter a number (Optional)" value={number} onChange={onNumberChanged} />
            </div>
            <div>
              <select name="type" value={type} onChange={onTypeChanged}>
                <option value="trivia">Trivia</option>
                <option value="math">Math</option>
                <option value="date">Date</option>
                <option value="year">Year</option>
              </select>
            </div>
            <button type="submit">Generate</button>
</form>);

export default Form;