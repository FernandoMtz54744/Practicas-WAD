package com.ipn.mx.modelos.dto;

import com.ipn.mx.modelos.entidades.Alumno;

/**
 *
 * @author Fernando Mtz
 */
public class AlumnoDTO {
    private Alumno entidad;
    
    public AlumnoDTO(){
        entidad = new Alumno();
    }
    
    public void setEntidad(Alumno entidad){
        this.entidad = entidad;
    }

    public Alumno getEntidad() {
        return entidad;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(entidad.getIdAlumno()).append("\n");
        sb.append("Nombre: ").append(entidad.getNombreAlumno()).append("\n");
        sb.append("Paterno: ").append(entidad.getPaternoAlumno()).append("\n");
        sb.append("Materno: ").append(entidad.getMaternoAlumno()).append("\n");
        sb.append("Email: ").append(entidad.getEmailAlumno()).append("\n");
        sb.append("Clave Carrera: ").append(entidad.getCarrera()).append("\n");
        return sb.toString();
    }
}
