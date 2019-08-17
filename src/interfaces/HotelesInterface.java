package interfaces;

import modelo.Hoteles;

public interface HotelesInterface {

    public String agregarHotel(Hoteles hotel);

    public String modificarHotel(Hoteles hotel, String correo);

    public short verHotelId(String correo);
}
