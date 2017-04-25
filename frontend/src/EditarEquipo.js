/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import React, { Component } from 'react';
import logo from './logo.svg';
import axios from 'axios';
import fetch from 'isomorphic-fetch';

class EditarEquipo extends Component {


  constructor(props){
    super(props);

    this.state = {teams: ''};
    this.handleClick = this.handleClick.bind(this);
  }
 
 
 componentEdit(){
  

      var nombre = document.getElementById("nombreE").value;
      var anio = document.getElementById("anioE").value;
      var titulos = document.getElementById("titulosE").value;


      console.log(nombre);
      console.log(anio);
      console.log(titulos);

      fetch('http://localhost:8080/_ah/api/echo/v1/editarEquipo',{
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
      this.componentEdit();
  }


  render() {
    return (
      <div className="EditarEquipo">       

        <form id="form1">
          Nombre Equipo:<br/>
          <input type="text" name="nombreEditar" id="nombreE"/><br/>
          Año de fundación:<br/>
          <input type="text" name="anioEditar" id="anioE"/><br/>
          titulos:<br/>
          <input type="text" name="titulosEditar" id="titulosE"/><br/><br/>
          
          <button onClick={this.handleClick}>Editar</button>
        </form>
      </div>
    );
  }
}


export default EditarEquipo;