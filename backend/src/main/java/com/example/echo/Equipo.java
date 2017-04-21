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


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author daca-solutions
 */


@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByNombreEquipo", query = "SELECT e FROM Equipos e WHERE e.nombreEquipo = :nombreEquipo")
    , @NamedQuery(name = "Equipos.findByAnioFundacion", query = "SELECT e FROM Equipos e WHERE e.anioFundacion = :anioFundacion")
    , @NamedQuery(name = "Equipos.findByTitulosGanados", query = "SELECT e FROM Equipos e WHERE e.titulos = :titulos")})

public class Equipo implements Serializable {
   private static final long serialVersionUID = 1L;
    
    
    @Id
    @Column(name = "nombreEquipo")
    private String nombreEquipo;
    
    @Column(name = "anioFundacion")
    private String anioFundacion;
    
    @Column(name = "titulos")
    private String titulos;

    public Equipo() {
    }

 
    public Equipo (String nNombre, String nAnioFundation, String nTitulos){

    nombreEquipo=nNombre;
    anioFundacion=nAnioFundation;
    titulos=nTitulos;

    }


    public String getNombre() {
        return nombreEquipo;
    }

    public void setNombre(String nombre) {
        this.nombreEquipo = nombre;
    }

    public String getAnioFundation() {
        return anioFundacion;
    }

    public void setAnioFundation(String anioFundation) {
        this.anioFundacion = anioFundation;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreEquipo != null ? nombreEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.nombreEquipo == null && other.nombreEquipo != null) || (this.nombreEquipo != null && !this.nombreEquipo.equals(other.nombreEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipo[ nombreEquipo=" + nombreEquipo + " ]";
    }

    
    
    
}
