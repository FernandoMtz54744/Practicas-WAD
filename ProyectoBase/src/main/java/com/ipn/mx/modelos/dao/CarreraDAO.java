package com.ipn.mx.modelos.dao;

import com.ipn.mx.modelos.dto.CarreraDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Mtz
 */
public class CarreraDAO {
    private static final String SQL_INSERT = "insert into Carreras(nombreCarrera, descripcionCarrera) values(?,?)";
    private static final String SQL_UPDATE = "update Carreras set nombreCarrera=?, descripcionCarrera=? where idCarrera=?";
    private static final String SQL_DELETE = "delete from Carreras where idCarrera=?";
    private static final String SQL_SELECT = "select * from Carreras where idCarrera=?";
    private static final String SQL_SELECT_ALL = "select * from Carreras";
    
    private Connection conexion;
    
    public CarreraDAO(){
        
    }
    
    public void getConexion(){
        String usuario = "root";
        String clave = "n0m3l0"; 
        String url="jdbc:mysql://localhost:3306/EscuelaWeb";
        String driverBD = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverBD);
            conexion = DriverManager.getConnection(url,usuario, clave);
        } catch (Exception ex) {
            System.out.println("Error obtener conexion: " + ex.getMessage());
        }
    }
    
    public void create(CarreraDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCarrera());
            ps.setString(2, dto.getEntidad().getDescripcionCarrera());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al insertar carrera");
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
    
    public CarreraDTO read(CarreraDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        CarreraDTO carreradto = null;
        try{
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setLong(1, dto.getEntidad().getIdCarrera());
            rs = ps.executeQuery();
            if(rs.next()){
                carreradto = new CarreraDTO();
                carreradto.getEntidad().setIdCarrera(rs.getLong("idCarrera"));
                carreradto.getEntidad().setNombreCarrera(rs.getString("nombreCarrera"));
                carreradto.getEntidad().setDescripcionCarrera(rs.getString("descripcionCarrera"));
            }
        }catch(Exception e){
            System.out.println("Error al seleccionar carrera");
            e.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }
        return carreradto;
    }
    
    public void update(CarreraDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCarrera());
            ps.setString(2, dto.getEntidad().getDescripcionCarrera());
            ps.setInt(3, dto.getEntidad().getIdCarrera().intValue());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al actualizar carrera");
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
    
    public void delete(CarreraDTO dto) throws SQLException{
        getConexion();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCarrera().intValue());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al actualizar carrera");
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
                CarreraDTO carrera = new CarreraDTO();
                carrera.getEntidad().setIdCarrera(rs.getLong("idCarrera"));
                carrera.getEntidad().setNombreCarrera(rs.getString("nombreCarrera"));
                carrera.getEntidad().setDescripcionCarrera(rs.getString("descripcionCarrera"));
                resultados.add(carrera);
            }
        }catch(Exception e){
            System.out.println("Error al actualizar carrera");
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
