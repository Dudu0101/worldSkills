package modelo;

public class Hoteles_Habitaciones {

    private String nombre;
    private String correoElectronico;
    private String categoria;
    private int telefono;
    private String ciudad;
    private String pais;
    private String direccion;
    private int cantidadHabitaciones;

    public Hoteles_Habitaciones(String nombre, String correoElectronico, String categoria, int telefono, String ciudad, String pais, String direccion, int cantidadHabitaciones) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.categoria = categoria;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.direccion = direccion;
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public Hoteles_Habitaciones() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

}
