package modelo.entidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    
    
    public static void main(String[] args) {
        Alumno a = new Alumno();
        a.setNombreAlumno("Esmeralda");
        a.setPaternoAlumno("Godinez");
        a.setMaternoAlumno("Montero");
        a.setEmailAlumno("esmegod19@gmail.com");
        a.setFechaCreacion(new Date());
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoBase_5");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
               
                
    }
    
}
