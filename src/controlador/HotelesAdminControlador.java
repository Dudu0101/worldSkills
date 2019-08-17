package controlador;

import static controlador.VariablesStaticas.correo;
import dao.CiudadesPaisesDao;
import dao.Hoteles_HabitacionesDao;
import dao.PaisesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudades_Paises;
import modelo.Hoteles_Habitaciones;
import modelo.Paises;
import vista.JfrmAddHotel;
import vista.JfrmAdminHoteles;
import vista.JfrmModificarHotel;

public class HotelesAdminControlador implements ActionListener, KeyListener, MouseListener {

    //Frames a importar
    JfrmAddHotel vistaAdd = new JfrmAddHotel();
    JfrmModificarHotel vistaMod = new JfrmModificarHotel();
    public static JfrmAdminHoteles formHoteles;
    
    //Controladores a importar
    HotelesAddControlador controladorAdd = new HotelesAddControlador(vistaAdd);
    HotelesModControlador controladorMod = new HotelesModControlador(vistaMod);

    DefaultComboBoxModel paises = new DefaultComboBoxModel();

    //Titulo de la tabla y modelo a utilizar
    String[] titulos = {"No.", "Nombre", "Categoría", "Correo Electronico", "Télefono", "Ciudad", "Direccion", "Cantidad de habitaciones"};
    DefaultTableModel tabla = new DefaultTableModel(titulos, 0);

    //Daos a utilizar
    CiudadesPaisesDao daoCiudades = new CiudadesPaisesDao();
    PaisesDao daoPaises = new PaisesDao();
    Hoteles_HabitacionesDao daoHabitaciones = new Hoteles_HabitacionesDao();

    //Modelos a importar
    Ciudades_Paises ciudades = new Ciudades_Paises();
    Hoteles_Habitaciones habitaciones = new Hoteles_Habitaciones();

    private boolean confirmar = false;

    public HotelesAdminControlador(JfrmAdminHoteles formHoteles) {
        this.formHoteles = formHoteles;
        aniadirActionListeners();
        llenarPaises();
        formHoteles.jLblUsuario.setText("Usuario: Soyel Administrador");
        formHoteles.jBtnMod.setEnabled(false);
        verHoteles();
        tamanios();
    }

    public void aniadirActionListeners() {
        formHoteles.JBtnAdd.addActionListener(this);
        formHoteles.jBtnDelete.addActionListener(this);
        formHoteles.jBtnMod.addActionListener(this);
        formHoteles.jCmbxCiudades.addActionListener(this);
        formHoteles.jCmxPaises.addActionListener(this);
        formHoteles.jTxtNombre.addKeyListener(this);
        formHoteles.jTblHoteles.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formHoteles.jCmxPaises) {
            llenarCiudades();
            verHotelesCiudad();
            tamanios();
        }

        if (e.getSource() == formHoteles.jCmbxCiudades) {
            verHotelesCiudad();
            tamanios();
        }

        if (e.getSource() == formHoteles.jBtnMod) {
            obtenerDatos();
            if (confirmar == true) {
                JOptionPane.showMessageDialog(vistaMod, "Seleccione una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else if (confirmar == false) {
                vistaMod.setVisible(true);
            }
        }
        if (e.getSource() == formHoteles.JBtnAdd) {
            HotelesAddControlador controlador= new HotelesAddControlador(vistaAdd);
            vistaAdd.setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    *Método para filtrar los hoteles por nombre
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == formHoteles.jTxtNombre) {
            String nombre = formHoteles.jTxtNombre.getText();
            verHotelesNombre(nombre);
            tamanios();
            if (formHoteles.jTxtNombre.getText().isEmpty()) {
                verHoteles();
                tamanios();
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        formHoteles.jBtnMod.setEnabled(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void limpiarTabla() {
        // tabla = new DefaultTableModel(titulos, 0);
        int table = tabla.getRowCount() - 1;
        for (int i = table; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    //Metodo para ver los hoteles y las habitaciones que posee
    public void verHoteles() {
        limpiarTabla();
        //tabla = new DefaultTableModel(titulos, 0);
        Object[] filas = new Object[9];
        for (Hoteles_Habitaciones hothab : daoHabitaciones.verHoteles()) {
            filas[0] = tabla.getRowCount() + 1;
            filas[1] = hothab.getNombre();
            filas[3] = hothab.getCorreoElectronico();
            filas[2] = hothab.getCategoria();
            filas[4] = hothab.getTelefono();
            filas[5] = hothab.getCiudad();
            filas[6] = hothab.getPais();
            filas[7] = hothab.getDireccion();
            filas[8] = hothab.getCantidadHabitaciones();
            tabla.addRow(filas);
        }
        formHoteles.jTblHoteles.setModel(tabla);
    }

    /*
    *Metodo para ver los hoteles respectivos a determinadad Ciudad
     */
    public void verHotelesCiudad() {
        limpiarTabla();
        //tabla = new DefaultTableModel(titulos, 0);
        Object[] filas = new Object[9];
        habitaciones.setCiudad(String.valueOf(formHoteles.jCmbxCiudades.getSelectedItem()));
        for (Hoteles_Habitaciones hothab : daoHabitaciones.verHotelesCiudad(habitaciones)) {
            filas[0] = tabla.getRowCount() + 1;
            filas[1] = hothab.getNombre();
            filas[3] = hothab.getCorreoElectronico();
            filas[2] = hothab.getCategoria();
            filas[4] = hothab.getTelefono();
            filas[5] = hothab.getCiudad();
            filas[6] = hothab.getPais();
            filas[7] = hothab.getDireccion();
            filas[8] = hothab.getCantidadHabitaciones();
            tabla.addRow(filas);
        }
        formHoteles.jTblHoteles.setModel(tabla);
    }

    /*
    *Metodo para filtrar los hoteles por nombre
     */
    public void verHotelesNombre(String nombre) {
        limpiarTabla();
        Object[] filas = new Object[9];
        habitaciones.setNombre(nombre);
        for (Hoteles_Habitaciones hothab : daoHabitaciones.verHotelesNombre(habitaciones)) {
            filas[0] = tabla.getRowCount() + 1;
            filas[1] = hothab.getNombre();
            filas[3] = hothab.getCorreoElectronico();
            filas[2] = hothab.getCategoria();
            filas[4] = hothab.getTelefono();
            filas[5] = hothab.getCiudad();
            filas[6] = hothab.getPais();
            filas[7] = hothab.getDireccion();
            filas[8] = hothab.getCantidadHabitaciones();
            tabla.addRow(filas);
        }
        formHoteles.jTblHoteles.setModel(tabla);
    }

    /*
    *Metodo para asignar tamaños especificos a la tabla para hacerla más
    *amigable a la vista del usuario
     */
    public void tamanios() {
        formHoteles.jTblHoteles.getColumnModel().getColumn(0).setMaxWidth(35);
        formHoteles.jTblHoteles.getColumnModel().getColumn(5).setMinWidth(0);
        formHoteles.jTblHoteles.getColumnModel().getColumn(5).setMaxWidth(0);
        formHoteles.jTblHoteles.getColumnModel().getColumn(6).setMinWidth(0);
        formHoteles.jTblHoteles.getColumnModel().getColumn(6).setMaxWidth(0);
        formHoteles.jTblHoteles.getColumnModel().getColumn(7).setMinWidth(0);
        formHoteles.jTblHoteles.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    /*
    *Método para asignar datos a la vista para modificar los hoteles
     */
    public void obtenerDatos() {
        try {
            confirmar = false;
            vistaMod.jTxtNombreMod.setText(String.valueOf(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 1)));
            vistaMod.jTxtCorreoMod.setText(String.valueOf(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 3)));
            correo=String.valueOf(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 3));
            vistaMod.jTxtTelefonoMod.setText(String.valueOf(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 4)));
            vistaMod.jTxtDireccionMod.setText(String.valueOf(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 7)));
            vistaMod.jCmbxPaiseMod.setSelectedItem(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 6));
            vistaMod.jCmbCiudadesMod.setSelectedItem(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 5));
            if(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 2).equals("1 Estrellas")){
                vistaMod.jRbtnCat1Mod.setSelected(true);
            } else if(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 2).equals("2 Estrellas")){
                vistaMod.jRbtnCat2Mod.setSelected(true);
            } else if(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 2).equals("3 Estrellas")){
                vistaMod.jRbtnCat3Mod.setSelected(true);
            }else if(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 2).equals("4 Estrellas")){
                vistaMod.jRbtnCat4Mod.setSelected(true);
            }else if(formHoteles.jTblHoteles.getValueAt(formHoteles.jTblHoteles.getSelectedRow(), 2).equals("5 Estrellas")){
                vistaMod.jRbtnCat5Mod.setSelected(true);
            }
        } catch (Exception e) {
            confirmar = true;
        }
    }

}
