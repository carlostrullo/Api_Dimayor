/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React, { Component,PropTypes } from 'react';
import logo from './logo.svg';
import axios from 'axios';
import fetch from 'isomorphic-fetch';
//import React, {PropTypes} from 'react';


class AgregarEquipo extends Component {


state = {
    isShowingModal: false,
  }
  
  
  
  
  constructor(props){
     
    super(props);
    this.handleClick = this.handleClick.bind(this);
  }
 

 componentFetch() {
  

      var nombre = document.getElementById("nombreD").value;
      var anio = document.getElementById("anioD").value;
      var titulos = document.getElementById("titulosD").value;
      var name='';
            
      fetch('http://localhost:8080/_ah/api/echo/v1/agregarEquipo',{
      method : 'POST', body : JSON.stringify({
      "name" : nombre,
      "anio" : anio,
      "titulos" : titulos })
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
      this.componentFetch();
      document.getElementById("nombreD").setValue("");
      
     
  }



  render() {
      
      
    return (
      <div className="AgregarEquipo">
        <form id="form1">
          Nombre Equipo:<br/>
          <input type="text" name="nombre " id="nombreD"/><br/>
          Año de fundación:<br/>
          <input type="text" name="anio" id="anioD"/><br/>
          titulos:<br/>
          <input type="text" name="titulos" id="titulosD"/><br/><br/> 
          <button onClick={this.handleClick}>Registrar</button>
  
  
        </form>
      </div>
    );
  }
}


export default AgregarEquipo;



