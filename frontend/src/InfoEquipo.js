/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React, { Component } from 'react';
import logo from './logo.svg';
import axios from 'axios';
import fetch from 'isomorphic-fetch';


class InfoEquipo extends Component {


 constructor(props){
    super(props);

    this.state = {teams: ''};
    this.handleClick = this.handleClick.bind(this);
  }
  
  
  
  componentInfo(){
  
      var nombre = document.getElementById("nombreC").value;
      

      console.log(nombre);
     

      fetch('http://localhost:8080/_ah/api/echo/v1/infoEquipo',{
      method : 'POST', body : JSON.stringify({
      "name" : nombre})
  })
    .then(function (response) {
        
      return response.json()
      
    })
    .then((message) => {
        if(message.nombre!=null){
            name= "Nombre: "+ message.nombre+ "\n"+"titulos: "+message.titulos+"\n" +"Año fundación: "
    + message.anioFundation;
                 
    
            alert(name);
        }
        else{
            alert("El equipo que busca no se encuentra registrado");
        }
               
               
    });

  
 }
  
  
  
  componentAll(event){  
      
        event.preventDefault();
        console.log("entra");
      
      
      
      fetch('http://localhost:8080/_ah/api/echo/v1/equipos',{
      method : 'GET'
  })
    .then(function (response) {
        
      return response.json()
      
    })
    .then((items) => {
        
       
      alert(JSON.stringify(items));
               
               
    });
  }

  
  
  handleClick(event){
         event.preventDefault();
         this.componentInfo();
  }
  
   
  
   
  
 
    
  
render() {
    return (
      <div className="InfoEquipo">
        <form id="form1">
          Equipo a consultar:<br/>
          <input type="text" name="nombreConsulta" id="nombreC"/><br/>                             
          <button onClick={this.handleClick}>Consultar</button>
          <br/>
          <br/>
          Consultar todos los equipos<br/>
          <button onClick={this.componentAll}>Consultar</button>
          
        </form>




      </div>
    );
  }
}


export default InfoEquipo;


