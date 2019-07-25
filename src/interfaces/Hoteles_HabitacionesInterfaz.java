package interfaces;

import java.util.ArrayList;
import modelo.Hoteles_Habitaciones;

public interface Hoteles_HabitacionesInterfaz {
    
    public ArrayList<Hoteles_Habitaciones> verHoteles();
    
    public ArrayList<Hoteles_Habitaciones> verHotelesCiudad(Hoteles_Habitaciones hothab);
    
    public ArrayList<Hoteles_Habitaciones> verHotelesNombre(Hoteles_Habitaciones hothab);
}
