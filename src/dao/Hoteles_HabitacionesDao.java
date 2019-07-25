package dao;

import interfaces.Hoteles_HabitacionesInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Hoteles_Habitaciones;

public class Hoteles_HabitacionesDao implements Hoteles_HabitacionesInterfaz {

    Conexion cone = new Conexion();
    Hoteles_Habitaciones hothab;
    ArrayList<Hoteles_Habitaciones> lista;
    PreparedStatement ejecutar;
    ResultSet resultado;
    private String sql = null;

    @Override
    public ArrayList<Hoteles_Habitaciones> verHoteles() {
        try {
            lista = new ArrayList();
            cone.abrirConexion();
            sql = "select * from hoteles_habitaciones";
            ejecutar = cone.getConexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                hothab = new Hoteles_Habitaciones();
                hothab.setNombre(resultado.getString("nombre"));
                hothab.setCorreoElectronico(resultado.getString("correoelectronico"));
                hothab.setCategoria(resultado.getString("categoria_nombre"));
                hothab.setTelefono(resultado.getInt("telefono"));
                hothab.setCiudad(resultado.getString("ciudad"));
                hothab.setCantidadHabitaciones(resultado.getInt("cantidad_habitaciones"));
                lista.add(hothab);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("Error en daoVerHoteles " + e);
        } finally {
            cone.cerrarConexion();
        }
        return lista;
    }

    @Override
    public ArrayList<Hoteles_Habitaciones> verHotelesCiudad(Hoteles_Habitaciones hothab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Hoteles_Habitaciones> verHotelesNombre(Hoteles_Habitaciones hothab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
