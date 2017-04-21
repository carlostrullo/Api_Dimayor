/*
 * Copyright 2017 daca-solutions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.echo;

/**
 *
 * @author daca-solutions
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class Con {

private final EntityManagerFactory emf;
private final EntityManager entity;
private final ArrayList <Equipo> equipos;


    public Con(){

        equipos = new ArrayList<>();
        
        emf = Persistence.createEntityManagerFactory("conection");
        System.out.println("crea coneccion");
	entity = emf.createEntityManager();
        System.out.println("crea entityManager");
        
        
        //llenarEquipos();

    }


    
    
    
    



    public void llenarEquipos(){

        Equipo equ1= new Equipo("Deportivo cali", "1912", "9");
        Equipo equ2= new Equipo("Santa Fe", "1939", "9");
        Equipo equ3= new Equipo("Equidad", "1982", "0");
        Equipo equ4= new Equipo("Millonarios", "1946", "14");
        Equipo equ5= new Equipo("America", "1927", "13");
        Equipo equ6= new Equipo("Deportivo pasto", "1949", "1");
        Equipo equ7= new Equipo("Deportes Tolima", "1912", "1");

        equipos.add(equ1);
        equipos.add(equ2);
        equipos.add(equ3);
        equipos.add(equ4);
        equipos.add(equ5);
        equipos.add(equ6);
        equipos.add(equ7);

    }
    
    
    public Equipo darEquipo (String nombre){
        //actualizarEquipos();
        Equipo ret=null ;
           
        try {
            String s="SELECT * FROM Equipo WHERE nombreEquipo="+"'"+nombre+"'"+";";
	                Query q = entity.createNativeQuery(s);
			 List<Object[]> equi = q.getResultList();
                         for (Object[] a : equi) {
                             
                             Object t= a[0];
                             Object w= a[1];
                             Object y= a[2];
                             String nombrex=t.toString();
                             String aniox=w.toString();
                             String titulox=y.toString();
                             
                             Equipo temp= new Equipo(nombrex, aniox,titulox);                            
                             ret=temp;
                             
                          System.out.println("Equipo "+ temp.getNombre()+ " "+ temp.getAnioFundation() +" "+temp.getTitulos());
                         }
                                                                                                
			 //equipos.addAll(list);
                         
		} catch (Exception e) {
			e.printStackTrace();
		} 
              
       /* for (int i=0; i<equipos.size();i++){
            if (equipos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                ret = equipos.get(i);
                System.out.println("crea equipo");
            }
        }*/

        return ret;


    }


    public ArrayList<Equipo> getEquipos() {
        
        
        try {
            String s="SELECT * FROM Equipo;";
	Query q = entity.createNativeQuery(s);
			 List<Equipo> list = q.getResultList();
                         System.out.println("trae resultados");
			 equipos.addAll(list);
                        
                         
                         

		} catch (Exception e) {
			e.printStackTrace();
		} 
		    
        
        return equipos;
    }



    public boolean editarInformacionEquipo(String nombre, String anioFun,String titulos){
        
              

        Equipo equi= darEquipo(nombre);

        if (equi!=null){
            
        String s="UPDATE Equipo SET anionFundacion="+"'"+anioFun+"'"+"WHERE nombreEquipo="+"'"+nombre+"'"+";";
	Query q = entity.createNativeQuery(s);
        q.executeUpdate();
        
        
        String w="UPDATE Equipo SET titulos="+"'"+titulos+"'"+"WHERE nombreEquipo="+"'"+nombre+"'"+";";
	Query a= entity.createNativeQuery(w);
        a.executeUpdate();   
            return true;
            
            

        }

        else{
            return false;
        }



    }


    public boolean eliminarEquipo(String nombre){

        Equipo e= darEquipo(nombre);
        
        if(nombre.equalsIgnoreCase(e.getNombre())){
            String s="DELETE FROM Equipo WHERE nombreEquipo="+"'"+nombre+"'"+";";
            Query q = entity.createNativeQuery(s);
            q.executeUpdate();            
            return true;   
        }
        
        else{
            
               return false;  
            
        }
        
        
        /*for (int i=0; i<equipos.size();i++){
            if (equipos.get(i).getNombre().equals(nombre)) {
                equipos.remove(i);
                return true;
            }
        }*/
     

    }



    public boolean agregarEquipo(String nom, String aniofun, String titulos){

        if(nom!=null&&aniofun!=null&&titulos!=null) {

            if (darEquipo(nom) == null) {

                //Equipo equi = new Equipo(nom, aniofun, titulos);
                //equipos.add(equi);
                
                
                String s="INSERT INTO Equipo VALUES("+"'"+nom+"',"+"'"+aniofun+"',"+"'"+titulos+"')";
                Query q = entity.createNativeQuery(s);
                q.executeUpdate(); 
                System.out.println("ejecuta query");
                
                return true;
            }

            else {
                
                System.out.println("no ejecuta query");
                return false;
            }

        }

        else{
            return false;
        }

    }
    
    
}
