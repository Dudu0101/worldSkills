package dao;

import interfaces.HotelesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hoteles;

public class HotelesDao implements HotelesInterface {

    Conexion conexion = new Conexion();
    PreparedStatement ejecutar;
    ResultSet resultado;
    Hoteles hoteles= new Hoteles();

    private String mensaje = null;
    private String sql = null;

    @Override
    public String agregarHotel(Hoteles hotel) {
        conexion.abrirConexion();
        try {
            sql = "insert into hoteles(nombre, correoelectronico, telefono, direccion,"
                    + " ciudad_id, categoria_id, usuario_id) values(?,?,?,?,?,?,777)";
            ejecutar = conexion.getConexion().prepareStatement(sql);
            ejecutar.setString(1, hotel.getNombre());
            ejecutar.setString(2, hotel.getCorreoElectronico());
            ejecutar.setInt(3, hotel.getTelefono());
            ejecutar.setString(4, hotel.getDireccion());
            ejecutar.setShort(5, hotel.getCiudad_id());
            ejecutar.setByte(6, hotel.getCategoria_id());
            ejecutar.executeUpdate();
            mensaje = "Hotel agregado con Exito";
            hoteles.setCorreoElectronico(hotel.getCorreoElectronico());
        } catch (SQLException ex) {
            System.out.println("Error en addHoteles " + ex);
        } finally {
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarHotel(Hoteles hotel, String correo) {
        conexion.abrirConexion();
        try {
            sql = "update hoteles set nombre=?, correoelectronico=?, telefono=?, direccion=?, "
                    + "ciudad_id=?, categoria_id=?, usuario_id=777 where correoelectronico=?";
            ejecutar = conexion.getConexion().prepareStatement(sql);
            ejecutar.setString(1, hotel.getNombre());
            ejecutar.setString(2, hotel.getCorreoElectronico());
            ejecutar.setInt(3, hotel.getTelefono());
            ejecutar.setString(4, hotel.getDireccion());
            ejecutar.setShort(5, hotel.getCiudad_id());
            ejecutar.setByte(6, hotel.getCategoria_id());
            ejecutar.setString(7, correo);
            ejecutar.executeUpdate();
            mensaje = "Datos modificados con exito";
        } catch (SQLException ex) {
            System.out.println("Error en daoModificarHotel " + ex);
        } finally {
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public short verHotelId(String correo) {
        short hotelId=0;
        conexion.abrirConexion();
        sql="select hotel_id from hoteles where correoelectronico=?";
        try {
            ejecutar=conexion.getConexion().prepareStatement(sql);
            ejecutar.setString(1, correo);
            resultado=ejecutar.executeQuery();
            resultado.next();
            hoteles.setHotel_id(resultado.getShort("hotel_id"));
            resultado.close();
            hotelId=hoteles.getHotel_id();
            System.out.println(hotelId);
        } catch (SQLException ex) {
            System.out.println("Error en dao verHotelId" + ex);
        } finally{
            conexion.cerrarConexion();
        }
        return hotelId;
    }
}
