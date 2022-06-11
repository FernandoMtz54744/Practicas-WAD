package modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.entidades.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class AlumnoDAO {

    public void create(Alumno a) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(a);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            he.printStackTrace();
            System.out.println("Error: " + he.getMessage());
        }

    }

    public List readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List resultados = new ArrayList();
        try {
            transaction.begin();
            Query q = session.createQuery("from Alumno", Alumno.class);
            resultados = q.list();
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        AlumnoDAO dao  = new AlumnoDAO();
        Alumno a = new Alumno();
        a.setNombreAlumno("Fernando");
        a.setPaternoAlumno("Martinez");
        a.setMaternoAlumno("Martinez");
        a.setEmailAlumno("fer_f@outlook.com");
        a.setFechaCreacion(new Date());
        dao.create(a);
    }

}
