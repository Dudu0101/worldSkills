package dao;

import interfaces.Hoteles_HabitacionesInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hoteles_Habitaciones;

public class Hoteles_HabitacionesDao implements Hoteles_HabitacionesInterfaz {

    Conexion cone = new Conexion();
    Hoteles_Habitaciones hothabs;
    ArrayList<Hoteles_Habitaciones> lista;
    PreparedStatement ejecutar;
    ResultSet resultado;
    private String sql = null;

    //Metodo para visualizar todos los datos de hoteles
    @Override
    public ArrayList<Hoteles_Habitaciones> verHoteles() {
        try {
            lista = new ArrayList();
            cone.abrirConexion();
            sql = "select * from hoteles_habitaciones";
            ejecutar = cone.getConexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                hothabs = new Hoteles_Habitaciones();
                hothabs.setNombre(resultado.getString("nombre"));
                hothabs.setCorreoElectronico(resultado.getString("correoelectronico"));
                hothabs.setCategoria(resultado.getString("categoria_nombre"));
                hothabs.setTelefono(resultado.getInt("telefono"));
                hothabs.setCiudad(resultado.getString("ciudad"));
                hothabs.setPais(resultado.getString("pais"));
                hothabs.setDireccion(resultado.getString("direccion"));
                hothabs.setCantidadHabitaciones(resultado.getInt("cantidad_habitaciones"));
                lista.add(hothabs);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("Error en daoVerHoteles " + e);
        } finally {
            cone.cerrarConexion();
        }
        return lista;
    }

    //Metodo para ver los hoteles por ciudad
    @Override
    public ArrayList<Hoteles_Habitaciones> verHotelesCiudad(Hoteles_Habitaciones hothab) {
        lista = new ArrayList();
        cone.abrirConexion();
        sql = "select * from hoteles_habitaciones where ciudad=?";
        try {
            ejecutar = cone.getConexion().prepareStatement(sql);
            ejecutar.setString(1, hothab.getCiudad());
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                hothabs = new Hoteles_Habitaciones();
                hothabs.setNombre(resultado.getString("nombre"));
                hothabs.setCorreoElectronico(resultado.getString("correoelectronico"));
                hothabs.setCategoria(resultado.getString("categoria_nombre"));
                hothabs.setTelefono(resultado.getInt("telefono"));
                hothabs.setCiudad(resultado.getString("ciudad"));
                hothabs.setDireccion(resultado.getString("direccion"));
                hothabs.setCantidadHabitaciones(resultado.getInt("cantidad_habitaciones"));
                lista.add(hothabs);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerHotelesCiudad " + ex);
        } finally {
            cone.cerrarConexion();
        }
        return lista;
    }

    //Metodo para ver los hoteles por nombre
    @Override
    public ArrayList<Hoteles_Habitaciones> verHotelesNombre(Hoteles_Habitaciones hothab) {
        lista = new ArrayList();
        cone.abrirConexion();
        sql = "select * from hoteles_habitaciones where nombre LIKE '"+hothab.getNombre()+"%'";
        try {
            ejecutar = cone.getConexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                hothabs = new Hoteles_Habitaciones();
                hothabs.setNombre(resultado.getString("nombre"));
                hothabs.setCorreoElectronico(resultado.getString("correoelectronico"));
                hothabs.setCategoria(resultado.getString("categoria_nombre"));
                hothabs.setTelefono(resultado.getInt("telefono"));
                hothabs.setCiudad(resultado.getString("ciudad"));
                hothabs.setDireccion(resultado.getString("direccion"));
                hothabs.setCantidadHabitaciones(resultado.getInt("cantidad_habitaciones"));
                lista.add(hothabs);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerHotelesNombre " + ex);
        } finally{
            cone.cerrarConexion();
        }
        return lista;
    }

}
