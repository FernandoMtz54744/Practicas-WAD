package com.ipn.mx.modelos.dto;

import com.ipn.mx.modelos.entidades.Carrera;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Fernando Mtz
 */

//Patron DTO (Data Transfer Object)
public class CarreraDTO implements Serializable {
    private Carrera entidad;
    
    public CarreraDTO(){
        entidad = new Carrera();
    }

    public Carrera getEntidad() {
        return entidad;
    }

    public void setEntidad(Carrera entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        return "CarreraDTO{\n" + "\tClave de la carrera: " + entidad.getIdCarrera() + "\n" +
                "\tNombre de la carrera: " + entidad.getNombreCarrera() + "\n" +
                "\tDescripcion de la carrera: " + entidad.getDescripcionCarrera() + "\n}";
    }
}
