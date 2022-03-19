package com.ipn.mx.modelos.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipn.mx.modelos.dto.AlumnoDTO;

/**
 * @author Jaime Cortes
 * @author Esmeralda Godinez
 * @author Fernando Mtz
 */

public class AlumnoDAO {

    private static final String SQL_INSERT = "insert into Alumnos(nombreAlumno, paternoAlumno, maternoAlumno, emailAlumno, idCarrera) values(?,?,?,?,?) ";
    private static final String SQL_UPDATE = "update Alumnos set nombreAlumno=?, paternoAlumno=?, maternoAlumno=?, emailAlumno=?, idCarrera=? where idAlumno=?";
    private static final String SQL_DELETE = "delete from Alumnos where idAlumno=?";
    private static final String SQL_SELECT = "select * from Alumnos where idAlumno=?";
    private static final String SQL_SELECT_ALL = "select * from Alumnos";
    
    private Connection conexion;

    public void getConexion(){
        String usuario = "root";
        String clave = "n0m3l0"; 
        String url="jdbc:mysql://localhost:3306/EscuelaWeb";
        String driverBD = "com.mysql.cj.jdbc.Driver";
        try { 
            Class.forName(driverBD);
            conexion = DriverManager.getConnection(url,usuario, clave);
        }catch (Exception ex) {
            System.out.println("Error obtener conexion: " + ex.getMessage());
        }
    }
    
    public void create(AlumnoDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreAlumno());
            ps.setString(2, dto.getEntidad().getPaternoAlumno());
            ps.setString(3, dto.getEntidad().getMaternoAlumno());
            ps.setString(4, dto.getEntidad().getEmailAlumno());
            ps.setInt(5, dto.getEntidad().getCarrera());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al crear Alumno");
            e.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }
    }

    public void update(AlumnoDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreAlumno());
            ps.setString(2, dto.getEntidad().getPaternoAlumno());
            ps.setString(3, dto.getEntidad().getMaternoAlumno());
            ps.setString(4, dto.getEntidad().getEmailAlumno());
            ps.setInt(5, dto.getEntidad().getCarrera());
            ps.setInt(6, dto.getEntidad().getIdAlumno().intValue());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al actualizar Alumno");
            e.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }
    }

    public void delete(AlumnoDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdAlumno().intValue());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al eliminar Alumno");
            e.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }
    }

    public AlumnoDTO read(AlumnoDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        AlumnoDTO alumndodto = null;
        try{
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setLong(1, dto.getEntidad().getIdAlumno());
            rs = ps.executeQuery();
            if(rs.next()){
                alumndodto = new AlumnoDTO();
                alumndodto.getEntidad().setIdAlumno(rs.getLong("idAlumno"));
                alumndodto.getEntidad().setPaternoAlumno(rs.getString("paternoAlumno"));
                alumndodto.getEntidad().setMaternoAlumno(rs.getString("maternoAlumno"));
                alumndodto.getEntidad().setEmailAlumno(rs.getString("emailAlumno"));
                alumndodto.getEntidad().setCarrera(rs.getInt("idCarrera"));
            }
        }catch(Exception e){
            System.out.println("Error al seleccionar Alumno");
            e.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }
        return alumndodto;
    }

     public List readAll() throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List resultados = null;
        try{
            ps = conexion.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            resultados = new ArrayList();
            while(rs.next()){
                AlumnoDTO alumno = new AlumnoDTO();
                alumno.getEntidad().setIdAlumno(rs.getLong("idAlumno"));
                alumno.getEntidad().setNombreAlumno(rs.getString("nombreAlumno"));
                alumno.getEntidad().setPaternoAlumno(rs.getString("paternoAlumno"));
                alumno.getEntidad().setMaternoAlumno(rs.getString("maternoAlumno"));
                alumno.getEntidad().setEmailAlumno(rs.getString("emailAlumno"));
                alumno.getEntidad().setCarrera(rs.getInt("idCarrera"));
                resultados.add(alumno);
            }
        }catch(Exception e){
            System.out.println("Error al seleccionar todos los alumnos");
            e.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }
        return resultados;
    }




    
}
