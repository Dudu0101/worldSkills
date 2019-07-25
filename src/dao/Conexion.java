package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public static final String USER="duinlisi";
    public static final String URL="jdbc:mysql://localhost:3306/java19_ver";
    public static final String PASSWORD="1234";
    
    private Connection conexion;

    public void abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion realizada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en driver " + ex);;
        } catch (SQLException ex) {
            System.out.println("Error en daoAbrirConexion " + ex);
        }
    }
    
    public void cerrarConexion(){
        try {
            if((conexion.isClosed()==false) && (conexion!=null)){
                conexion.close();
                System.out.println("Conexion Cerrada");
            }
        } catch (SQLException ex) {
            System.out.println("Error en daoCerrarConexion" + ex);
        }
    }
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    

}
