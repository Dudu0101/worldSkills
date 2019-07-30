package dao;

import interfaces.Ciudades_PaisesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Ciudades_Paises;

public class CiudadesPaisesDao implements Ciudades_PaisesInterface {

    ResultSet resultado;
    PreparedStatement ejecutar;
    Conexion conec = new Conexion();
    Ciudades_Paises cidPais= new Ciudades_Paises();
    ArrayList<Ciudades_Paises> lista;

    private String sql = null;

    @Override
    public ArrayList<Ciudades_Paises> verCiudades(Ciudades_Paises cidpas) {
        try {
            conec.abrirConexion();
            lista = new ArrayList();
            sql = "select * from ciudades_pais where pais=?";
            ejecutar = conec.getConexion().prepareStatement(sql);
            ejecutar.setString(1, cidpas.getPais());
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                cidPais = new Ciudades_Paises();
                cidPais.setCiudad_id(resultado.getInt("ciudad_id"));
                cidPais.setCiudad(resultado.getString("ciudad"));
                lista.add(cidPais);
            }
        } catch (Exception e) {
            System.out.println("Error en daoVerCiudades " + e);
        } finally {
            conec.cerrarConexion();
        }
        return lista;
    }

}
