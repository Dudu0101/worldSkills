package modelo;

public class Hoteles {
    
    private short hotel_id;
    private String nombre;
    private String correoElectronico;
    private int telefono;
    private String direccion;
    private short ciudad_id;
    private byte categoria_id;
    private short usuario_id;

    public Hoteles(short hotel_id, String nombre, String correoElectronico, int telefono, String direccion, short ciudad_id, byte categoria_id, short usuario_id) {
        this.hotel_id = hotel_id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad_id = ciudad_id;
        this.categoria_id = categoria_id;
        this.usuario_id = usuario_id;
    }

    public Hoteles() {
    }

    public short getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(short hotel_id) {
        this.hotel_id = hotel_id;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public short getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(short ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public byte getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(byte categoria_id) {
        this.categoria_id = categoria_id;
    }

    public short getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(short usuario_id) {
        this.usuario_id = usuario_id;
    }
    

}
