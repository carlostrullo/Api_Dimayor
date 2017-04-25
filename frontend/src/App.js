import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import AgregarEquipo from './AgregarEquipo';
import EliminarEquipo from './EliminarEquipo';
import EditarEquipo from './EditarEquipo';
import InfoEquipo from './InfoEquipo';
import {StyleSheet,View} from 'react';

import axios from 'axios';



class App extends Component {
    
        
    constructor(props){
        super(props);
        
        this.state= {
          teams: []
        };
    }
    
    
    
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Dimayor</h2>
        </div>

 <span>
     <td><pre>     </pre>   </td>
     <td>  <AgregarEquipo /> </td>
   
     <td><pre>     </pre>   </td>
     <td>  <EliminarEquipo /> </td> 
    
    <td><pre>     </pre>   </td>
    <td><EditarEquipo /></td>
    
    <td><pre>     </pre>   </td>
    <td><InfoEquipo /></td>
 </span>
       <div>
       
       <div>
       </div>
       
        <ul>
        {
            //this.state.teams.map(team =>
            //<li key={team}>{team}</li>
            //)
}
         </ul>
        </div>
      </div>
    );
  }
  
  
  

  
  
}

export default App;
