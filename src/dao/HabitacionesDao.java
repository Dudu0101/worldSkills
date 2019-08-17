package dao;

import interfaces.HabitacionesInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Habitaciones;

public class HabitacionesDao implements HabitacionesInterface {

    Conexion conex = new Conexion();
    PreparedStatement ejecutar;

    private String sql = null;

    @Override
    public boolean agregarHabitaciones(short hotelId, byte tipoId) {
        conex.abrirConexion();
        try {
            sql = "insert into habitaciones(hotel_id, tipo_id, descripcion, precio, usuario_id) values(?, ?, ?, 145, 777)";
            ejecutar = conex.getConexion().prepareStatement(sql);
            ejecutar.setShort(1, hotelId);
            ejecutar.setByte(2, tipoId);
            ejecutar.setString(3, "Habitacion para 2 personas");
            ejecutar.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en daoAgregar Habitaciones" + ex);
        }
        return true;
    }

}
