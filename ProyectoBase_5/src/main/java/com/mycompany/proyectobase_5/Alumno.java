/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobase_5;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author escom
 */
@Entity
@Table 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombreAlumno", length =50, nullable=false)
    private String nombreAlumno;

    @Column(name = "paternoAlumno", length =50, nullable=false)
    private String paternoAlumno;
    
    @Column(name = "maternoAlumno", length =50, nullable=false)
    private String maternoAlumno; 
    
    @Column(name = "emailAlumno", length = 100, nullable=false)
    private String emailAlumno;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCreacion", nullable=false)
    private Date fechaCreacion; 
    
}
