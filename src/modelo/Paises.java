package modelo;

public class Paises {

    private int pais_id;
    private String nombre;
    private int codigo_area;

    public Paises(int pais_id, String nombre, int codigo_area) {
        this.pais_id = pais_id;
        this.nombre = nombre;
        this.codigo_area = codigo_area;
    }

    public Paises() {
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(int codigo_area) {
        this.codigo_area = codigo_area;
    }

}
