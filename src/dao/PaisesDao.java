package dao;

import interfaces.PaisesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Paises;

public class PaisesDao implements PaisesInterface {

    ResultSet resultado;
    PreparedStatement ejecutar;
    Conexion conec = new Conexion();
    Paises paises;
    ArrayList<Paises> lista;

    private String sql = null;

    @Override
    public ArrayList<Paises> verPaises() {
        lista = new ArrayList();
        conec.abrirConexion();
        sql = "select * from paises";
        try {
            ejecutar = conec.getConexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                paises = new Paises();
                paises.setNombre(resultado.getString("nombre"));
                paises.setPais_id(resultado.getInt("pais_id"));
                lista.add(paises);
            }
        } catch (Exception e) {
            System.out.println("Error en dao verPaises " + e);
        } finally {
            conec.cerrarConexion();
        }
        return lista;
    }

}
