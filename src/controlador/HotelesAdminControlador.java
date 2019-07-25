package controlador;

import dao.CiudadesPaisesDao;
import dao.Hoteles_HabitacionesDao;
import dao.PaisesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudades_Paises;
import modelo.Hoteles_Habitaciones;
import modelo.Paises;
import vista.JfrmAdminHoteles;

public class HotelesAdminControlador implements ActionListener {

    JfrmAdminHoteles formHoteles;
    DefaultComboBoxModel paises = new DefaultComboBoxModel();
    
    //Titulo de la tabla y modelo a utilizar
    String[] titulos={"No.", "Nombre", "Categoría", "Correo Electronico", "Télefono", "Ciudad", "Cantidad de habitaciones"};
    DefaultTableModel tabla= new DefaultTableModel(titulos, 0);

    //Daos a utilizar
    CiudadesPaisesDao daoCiudades = new CiudadesPaisesDao();
    PaisesDao daoPaises = new PaisesDao();
    Hoteles_HabitacionesDao daoHabitaciones= new Hoteles_HabitacionesDao();

    //Modelos a importar
    Ciudades_Paises ciudades = new Ciudades_Paises();
    
    //Indice para el correlativo de la tabla
    private int indice=1;
    

    public HotelesAdminControlador(JfrmAdminHoteles formHoteles) {
        this.formHoteles = formHoteles;
        aniadirActionListeners();
        llenarPaises();
        formHoteles.jLblUsuario.setText("Usuario: Soyel Administrador");
        verHoteles();
        tamanios();
    }

    public void aniadirActionListeners() {
        formHoteles.JBtnAdd.addActionListener(this);
        formHoteles.jBtnDelete.addActionListener(this);
        formHoteles.jBtnMod.addActionListener(this);
        formHoteles.jCmbxCiudades.addActionListener(this);
        formHoteles.jCmxPaises.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formHoteles.jCmxPaises) {
            llenarCiudades();
        }
    }

    
    //Metodo para llenar el ComboBox de Paises
    public void llenarPaises() {
        for (Paises pais : daoPaises.verPaises()) {
            paises.addElement(pais.getNombre());
        }
        formHoteles.jCmxPaises.setModel(paises);
    }

    
    //Metodo para llenar el ComboBox de Ciudades dependiendo el pais
    public void llenarCiudades() {
        DefaultComboBoxModel verCiudades = new DefaultComboBoxModel();
        ciudades.setPais(String.valueOf(formHoteles.jCmxPaises.getSelectedItem()));
        for (Ciudades_Paises cidpas : daoCiudades.verCiudades(ciudades)) {
            verCiudades.addElement(cidpas.getCiudad());
        }
        formHoteles.jCmbxCiudades.setModel(verCiudades);
    }
    
    
    //Método para actualizar y limpiar datos de la tabla
    public void limpiarTabla(){
        int table= tabla.getRowCount()-1;
        for (int i = table; i >=0; i--) {
            tabla.removeRow(i);
        }
    }
    
    
    //Metodo para ver los hoteles y las habitaciones que posee
    public void verHoteles(){
       limpiarTabla();
       Object[] filas= new Object[7];
        for (Hoteles_Habitaciones hothab : daoHabitaciones.verHoteles()) {
            filas[0]=indice++;
            filas[1]=hothab.getNombre();
            filas[3]=hothab.getCorreoElectronico();
            filas[2]=hothab.getCategoria();
            filas[4]=hothab.getTelefono();
            filas[5]=hothab.getCiudad();
            filas[6]=hothab.getCantidadHabitaciones();
            tabla.addRow(filas);
        }
        formHoteles.jTblHoteles.setModel(tabla);
    }
    
    //Metodo para asignar tamaños especificos a la tabla para hacerla más
    //amigable a la vista del usuario
    public void tamanios(){
        formHoteles.jTblHoteles.getColumnModel().getColumn(0).setMaxWidth(35);
        formHoteles.jTblHoteles.getColumnModel().getColumn(5).setMinWidth(0);
        formHoteles.jTblHoteles.getColumnModel().getColumn(5).setMaxWidth(0);
        
    }

}
