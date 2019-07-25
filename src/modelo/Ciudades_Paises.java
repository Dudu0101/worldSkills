package modelo;

public class Ciudades_Paises {

    private int ciudad_id;
    private String pais;
    private String ciudad;

    public Ciudades_Paises(int ciudad_id, String pais, String ciudad) {
        this.ciudad_id = ciudad_id;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public Ciudades_Paises() {
    }

    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
