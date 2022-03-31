package com.ipn.mx.modelos.entidades;

import java.io.Serializable;

/**
 *
 * @author Fernando Mtz
 */
public class Carrera implements Serializable{
    private Long idCarrera;
    private String nombreCarrera;
    private String descripcionCarrera;

    public Carrera() {
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDescripcionCarrera() {
        return descripcionCarrera;
    }

    public void setDescripcionCarrera(String descripcionCarrera) {
        this.descripcionCarrera = descripcionCarrera;
    }

    @Override
    public String toString() {
        return "Carrera{\n" + "\tidCarrera = " + idCarrera + "\n\tnombreCarrera = " + nombreCarrera 
                + "\n\tdescripcionCarrera = " + descripcionCarrera + "\n}";
    }
    
    
}
