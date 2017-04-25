/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import React, { Component } from 'react';
import logo from './logo.svg';
import axios from 'axios';
import fetch from 'isomorphic-fetch';


class EliminarEquipo extends Component {


 constructor(props){
    super(props);

    this.state = {teams: ''};
    this.handleClick = this.handleClick.bind(this);
  }
  
  
  
  componentDelete(){
  
      var nombre = document.getElementById("eliminarD").value;
      

      console.log(nombre);
     

      fetch('http://localhost:8080/_ah/api/echo/v1/eliminarEquipo',{
      method : 'POST', body : JSON.stringify({
      "name" : nombre })
  })
    .then(function (response) {
        
      return response.json()
      
    })
    .then((message) => {
        name= message.message
       
        alert(name);       
               
    });
    
 }
  
  
  
  
  handleClick(event){
      event.preventDefault();
      this.componentDelete();
      
  }
  
    
  
render() {
    return (
      <div className="EliminarEquipo">
        <form id="form1">
          Eliminar Equipo:<br/>
          <input type="text" name="eliminarEquipo" id="eliminarD"/><br/>
          
          
          <button onClick={this.handleClick}>Eliminar</button>
        </form>
      </div>
    );
  }
}


export default EliminarEquipo;

