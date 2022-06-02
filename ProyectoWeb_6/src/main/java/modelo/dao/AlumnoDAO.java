/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import util.HibernateUtil;


/**
 *
 * @author escom
 */
public class AlumnoDAO {
    
    public void create(Alumno a){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = null;
        try{
            transaction.begin();
            session.persist(a);
            transaction.commit();
        }
        catch(HibernateException he){
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
    
    }
    public List readAll(){
        Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List resultados = new ArrayList();
        try{
            transaction.begin();
            Query q = session.createQuery("from Alumno", Alumno.class);
            resultados = q.list();
            transaction.commit();
        }catch(HibernateException he){
             if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
                return resultados;
    }
    
          
}
