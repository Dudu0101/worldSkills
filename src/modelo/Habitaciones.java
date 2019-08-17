package modelo;

public class Habitaciones {

    private int hotel_id;
    private byte tipoId;
    private String descripcion;
    private double precio;

    public Habitaciones(int hotel_id, byte tipoId, String descripcion, double precio) {
        this.hotel_id = hotel_id;
        this.tipoId = tipoId;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Habitaciones() {
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public byte getTipoId() {
        return tipoId;
    }

    public void setTipoId(byte tipoId) {
        this.tipoId = tipoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
