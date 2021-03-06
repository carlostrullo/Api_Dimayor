/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.echo;


import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;


import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;

import java.util.ArrayList;

/** The Echo API which Endpoints will be exposing. */
// [START echo_api_annotation]
@Api(
    name = "echo",
    version = "v1")
// [END echo_api_annotation]
public class Echo {

  private Con con;
  public Echo(){

    con= new Con();

  }




  /**
   * Echoes the received message back. If n is a non-negative integer, the message is copied that
   * many times in the returned message.
   *
   * Note that name is specified and will override the default name of "{class name}.{method
   * name}". For example, the default is "echo.echo".
   *
   * Note that httpMethod is not specified. This will default to a reasonable HTTP method
   * depending on the API method name. In this case, the HTTP method will default to POST.
   */
  // [START echo_method]
 @ApiMethod(name = "echo")
  public Message echo(Message message, @Named("n") @Nullable Integer n) {
    return doEcho(message, n);
  }
  // [END echo_method]


  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,name="equipos", path="equipos")
  public ArrayList<Equipo> equipos(){
    return con.getEquipos();
  }



  @ApiMethod(name="infoEquipo", path="infoEquipo")
  public Equipo infoEquipo(@Named("name") String name){
      Equipo equi= con.darEquipo(name);
      

      if(equi!=null){
          return equi;
      }
      else{
         Equipo ret= new Equipo(null,null,null);
          return ret;
      }
  }



  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,name="editarEquipo",path="editarEquipo")
  public Message editarEquipo(@Named("name") String name,@Named("anio") String anio, @Named("titulos") String titulos){

      Message verdad= new Message ("el equipo se edito correctamente");
      Message falso= new Message ("el equipo no se encuentra en la lista");
       if(name!=""&& anio!=""&&titulos!=""){
      boolean ver= con.editarInformacionEquipo(name, anio, titulos);

      if(ver ==true){

          return doEcho(verdad,1);

      }
      else{
          return doEcho(falso,1);
      }
      
       }
       else{
           Message ret= new Message("por favor llene los campos");
          return ret;
       }
  }


  @ApiMethod (httpMethod = ApiMethod.HttpMethod.POST, name="eliminarEquipo", path="eliminarEquipo")
  public Message eliminarEquipo(@Named("name") String name){

      
      Message verdad= new Message ("el equipo se elimino correctamente");
      Message falso= new Message ("el equipo no se encuentra en la lista");
      if (name!=""){
        boolean ver= con.eliminarEquipo(name);

        if(ver ==true){

         return doEcho(verdad,1);

      }
       else{
          return doEcho(falso,1);
      }
      }
     else{
          Message ret= new Message("por favor ingrese un nombre");
          return ret;
          
      }
  
  }
      


  @ApiMethod (httpMethod = ApiMethod.HttpMethod.POST, name="agregarEquipo", path="agregarEquipo")
  public Message agregarEquipo(@Named("name") String name,@Named("anio") String anio, @Named("titulos") String titulos) {

      Message verdad = new Message(name +" "+" se agrego correctamente");
      Message falso = new Message("el equipo que intenta agregar ya existe");
      if(name!=""&& anio!=""&&titulos!=""){
      boolean ver = con.agregarEquipo(name,anio,titulos);

      if (ver == true) {

          return doEcho(verdad, 1);

      } else {
          return doEcho(falso, 1);
      }
      
      }
      else{
          Message ret= new Message("por favor llene los campos");
          return ret;
      }
  }



    @ApiMethod(name="pruebafinal", path="pruebafinal")
    public Message pruebafinal(@Named("name") String name,@Named("n") int n){

        Message men= new Message(name);
        return doEcho(men,n);

    }




  /**
   * Echoes the received message back. If n is a non-negative integer, the message is copied that
   * many times in the returned message.
   *
   * Note that name is specified and will override the default name of "{class name}.{method
   * name}". For example, the default is "echo.echo".
   *
   * Note that httpMethod is not specified. This will default to a reasonable HTTP method
   * depending on the API method name. In this case, the HTTP method will default to POST.
   */
  // [START echo_path]
  @ApiMethod(name = "echo_path_parameter", path = "echo/{n}")
  public Message echoPathParameter(Message message, @Named("n") int n) {
    return doEcho(message, n);
  }
  // [END echo_path]




  /**
   * Echoes the received message back. If n is a non-negative integer, the message is copied that
   * many times in the returned message.
   *
   * Note that name is specified and will override the default name of "{class name}.{method
   * name}". For example, the default is "echo.echo".
   *
   * Note that httpMethod is not specified. This will default to a reasonable HTTP method
   * depending on the API method name. In this case, the HTTP method will default to POST.
   */
  // [START echo_api_key]
  /*@ApiMethod(name = "echo_api_key", path = "echo_api_key", apiKeyRequired = AnnotationBoolean.TRUE)
  public Message echoApiKey(Message message, @Named("n") @Nullable Integer n) {
    return doEcho(message, n);
  }*/
  // [END echo_api_key]

  private Message doEcho(Message message, Integer n) {
    if (n != null && n >= 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (i > 0) {
          sb.append(" ");
        }
        sb.append(message.getMessage());
      }
      message.setMessage(sb.toString());
    }
    return message;
  }

  /**
   * Gets the authenticated user's email. If the user is not authenticated, this will return an HTTP
   * 401.
   *
   * Note that name is not specified. This will default to "{class name}.{method name}". For
   * example, the default is "echo.getUserEmail".
   *
   * Note that httpMethod is not required here. Without httpMethod, this will default to GET due
   * to the API method name. httpMethod is added here for example purposes.
   */
  // [START google_id_token_auth]
 /* @ApiMethod(
      httpMethod = ApiMethod.HttpMethod.GET,
      authenticators = {EspAuthenticator.class},
      audiences = {"YOUR_OAUTH_CLIENT_ID"},
      clientIds = {"YOUR_OAUTH_CLIENT_ID"}
      )
  public Email getUserEmail(User user) throws UnauthorizedException {
    if (user == null) {
      throw new UnauthorizedException("Invalid credentials");
    }

    Email response = new Email();
    response.setEmail(user.getEmail());
    return response;
  }*/
  // [END google_id_token_auth]

  /**
   * Gets the authenticated user's email. If the user is not authenticated, this will return an HTTP
   * 401.
   *
   * Note that name is not specified. This will default to "{class name}.{method name}". For
   * example, the default is "echo.getUserEmail".
   *
   * Note that httpMethod is not required here. Without httpMethod, this will default to GET due
   * to the API method name. httpMethod is added here for example purposes.
   */
  // [START firebase_auth]
  /*@ApiMethod(
      path = "firebase_user",
      httpMethod = ApiMethod.HttpMethod.GET,
      authenticators = {EspAuthenticator.class},
      issuerAudiences = {@ApiIssuerAudience(name = "firebase", audiences = {"pruebaq-162120"})}
      )
  public Email getUserEmailFirebase(User user) throws UnauthorizedException {
    if (user == null) {
      throw new UnauthorizedException("Invalid credentials");
    }

    Email response = new Email();
    response.setEmail(user.getEmail());
    return response;
  }*/
  // [END firebase_auth]
}