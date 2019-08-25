/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.HotelesAdminControlador.formHoteles;
import dao.CiudadesPaisesDao;
import dao.HabitacionesDao;
import dao.HotelesDao;
import dao.PaisesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Ciudades_Paises;
import modelo.Hoteles;
import modelo.Paises;
import vista.JfrmAddHotel;

/**
 *
 * @author javam2019
 */
public class HotelesAddControlador implements ActionListener, KeyListener {

    //Modelos a utilizar
    Hoteles hotel = new Hoteles();
    Paises paises = new Paises();
    Ciudades_Paises cidpas = new Ciudades_Paises();

    ArrayList<Ciudades_Paises> lista = new ArrayList();

    //Daos a utilizar
    HotelesDao dao = new HotelesDao();
    PaisesDao dao2 = new PaisesDao();
    CiudadesPaisesDao dao3 = new CiudadesPaisesDao();
    HabitacionesDao dao4 = new HabitacionesDao();

    //ComboBox para Paises
    DefaultComboBoxModel paisesAdd = new DefaultComboBoxModel();
    
    //Controlador a utilizar
    HotelesAdminControlador controlador;

    //llenar el combo de pais id
    DefaultComboBoxModel paisesIdAdd = new DefaultComboBoxModel();

    JfrmAddHotel addHotel;

    //Variable de tipo booleana para confirmar si alguno de los radio buttons esta seleccionado
    private boolean confirmarCategorias = false;
    private byte categoria;
    private int contarErroneas;
    private boolean verificacion = false;
    
    //Controlador
    HotelesAdminControlador controladorAdmin;

    public HotelesAddControlador(JfrmAddHotel addHotel) {
        this.addHotel = addHotel;
        setListeners();
        validarCampos();
        llenarPaisesHoteles();
        llenarCiudadesHoteles();
        addHotel.jBtnGuardar.setEnabled(false);
        addHotel.jCmbCiudadesHotelId.setVisible(false);
        addHotel.jLblError.setText("");
    }

    /*
    *Metodo para agregar action listeners a los campos
     */
    public void setListeners() {

        //Botones
        addHotel.jBtnGuardar.addActionListener(this);
        addHotel.jBtnCancelar.addActionListener(this);

        //Combo Box
        addHotel.jCmbxPaiseHotel.addActionListener(this);
        addHotel.jCmbCiudadesHotel.addActionListener(this);

        //Radio Buttons
        addHotel.jRbtnCat1.addActionListener(this);
        addHotel.jRbtnCat2.addActionListener(this);
        addHotel.jRbtnCat3.addActionListener(this);
        addHotel.jRbtnCat4.addActionListener(this);
        addHotel.jRbtnCat5.addActionListener(this);

        //Cajas de texto
        addHotel.jTxtNombreHotel.addKeyListener(this);
        addHotel.jTxtCorreoHotel.addKeyListener(this);
        addHotel.jTxtDireccionHotel.addKeyListener(this);
        addHotel.jTxtTelefonoHotel.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addHotel.jCmbxPaiseHotel) {
            llenarCiudadesHoteles();
        }

        if (e.getSource() == addHotel.jCmbCiudadesHotel) {
            addHotel.jCmbCiudadesHotelId.setSelectedIndex(addHotel.jCmbCiudadesHotel.getSelectedIndex());

        }

        if (e.getSource() == addHotel.jBtnGuardar) {
            validarCampos();
            agregarHoteles();
            addHotel.jBtnGuardar.setEnabled(false);
            confirmarCategorias = false;
            controlador= new HotelesAdminControlador(formHoteles);
        }

        if (e.getSource() == addHotel.jRbtnCat1
                || e.getSource() == addHotel.jRbtnCat2
                || e.getSource() == addHotel.jRbtnCat3
                || e.getSource() == addHotel.jRbtnCat4
                || e.getSource() == addHotel.jRbtnCat5) {
            //Verificamos si cualquier boton de la categoria fue seleccionado
            
            if (addHotel.jRbtnGrpCategoria.isSelected(addHotel.jRbtnGrpCategoria.getSelection())) {
                //Si alguno de los botones es seleccionado devolverá un true por lo tanto:
                
                confirmarCategorias = true;
                
                //Evaluamos aun si alguno de los TextField esta vacio o no
                addHotel.jBtnGuardar.setEnabled(!addHotel.jTxtNombreHotel.getText().isEmpty()
                        && !addHotel.jTxtDireccionHotel.getText().isEmpty()
                        && !addHotel.jTxtCorreoHotel.getText().isEmpty()
                        && !addHotel.jTxtTelefonoHotel.getText().isEmpty() && confirmarCategorias);
            }
        }

        if (e.getSource() == addHotel.jBtnCancelar) {
            addHotel.dispose();
            formHoteles.setEnabled(true);
            formHoteles.toFront();
            
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

    @Override
    public void keyReleased(KeyEvent e) {
        addHotel.jBtnGuardar.setEnabled(!addHotel.jTxtNombreHotel.getText().isEmpty()
                && !addHotel.jTxtDireccionHotel.getText().isEmpty()
                && !addHotel.jTxtCorreoHotel.getText().isEmpty()
                && !addHotel.jTxtTelefonoHotel.getText().isEmpty() && confirmarCategorias);
    }

    /*
    *Método para agregar validacion a los campos
     */
    public void validarCampos() {
        contarErroneas = 0;
        verificacion = false;
        Validar valid = new Validar();
        valid.ValidarSoloNumeros(addHotel.jTxtTelefonoHotel, 7);
        if (!addHotel.jTxtCorreoHotel.getText().contains("@")
                || !addHotel.jTxtCorreoHotel.getText().contains(".")) {
            addHotel.jLblError.setText("Correo Invalido");
            contarErroneas++;
        } else {
            addHotel.jLblError.setText(null);
        }

        if (contarErroneas == 0) {
            verificacion = true;
        }
    }

    /*
    *Metodo para llenar el ComboBox de Paises
     */
    public void llenarPaisesHoteles() {
        for (Paises pais : dao2.verPaises()) {
            paisesAdd.addElement(pais.getNombre());
            paisesIdAdd.addElement(pais.getPais_id());
        }
        addHotel.jCmbxPaiseHotel.setModel(paisesAdd);
    }

    /*
    *Metodo para llenar el ComboBox de Ciudades dependiendo el pais
     */
    public void llenarCiudadesHoteles() {
        DefaultComboBoxModel verCiudades = new DefaultComboBoxModel();
        //llenar el combo de ciudades
        DefaultComboBoxModel verCiudadesId = new DefaultComboBoxModel();
        cidpas.setPais(String.valueOf(addHotel.jCmbxPaiseHotel.getSelectedItem()));
        for (Ciudades_Paises cidpas : dao3.verCiudades(cidpas)) {
            //Ciudades_Paises nuevo =  new Ciudades_Paises(cidpas.getCiudad_id(), String.valueOf(cidpas.getCiudad()));
            verCiudadesId.addElement(cidpas.getCiudad_id());
            //lista.add(nuevo);
            verCiudades.addElement(cidpas.getCiudad());

        }
        addHotel.jCmbCiudadesHotel.setModel(verCiudades);
        addHotel.jCmbCiudadesHotelId.setModel(verCiudadesId);
    }

    /*
     * Método para borrar texto de las cajas
     */
    public void borrarCajas() {
        addHotel.jTxtCorreoHotel.setText("");
        addHotel.jTxtDireccionHotel.setText("");
        addHotel.jTxtNombreHotel.setText("");
        addHotel.jTxtTelefonoHotel.setText("");
        addHotel.jRbtnGrpCategoria.clearSelection();
    }

    public void tomarDatos() {
        hotel.setNombre(addHotel.jTxtNombreHotel.getText());
        hotel.setCorreoElectronico(addHotel.jTxtCorreoHotel.getText());
        hotel.setTelefono(Integer.parseInt(addHotel.jTxtTelefonoHotel.getText()));
        hotel.setDireccion(addHotel.jTxtDireccionHotel.getText());
        hotel.setCiudad_id(Short.parseShort(String.valueOf(addHotel.jCmbCiudadesHotelId.getSelectedItem())));
        if (addHotel.jRbtnCat1.isSelected()) {
            categoria = 101;
        } else if (addHotel.jRbtnCat2.isSelected()) {
            categoria = 102;
        } else if (addHotel.jRbtnCat3.isSelected()) {
            categoria = 103;
        } else if (addHotel.jRbtnCat4.isSelected()) {
            categoria = 104;
        } else if (addHotel.jRbtnCat5.isSelected()) {
            categoria = 105;
        }
        hotel.setCategoria_id(categoria);
    }

    /*
    *Método para agregar los Hoteles a la base de datos
     */
    public void agregarHoteles() {
        if (verificacion == true) {
            tomarDatos();
            JOptionPane.showMessageDialog(addHotel, dao.agregarHotel(hotel), "Información", JOptionPane.INFORMATION_MESSAGE);
            agregarHabitaciones();
            borrarCajas();
            addHotel.jTxtNombreHotel.requestFocus();
            addHotel.jLblError.setVisible(false);
        }

    }

    /*
     * Metodo para agregar Habitacion por defecto a la base de datos
     */
    public void agregarHabitaciones() {
        byte tipo = 1;
        String correo = hotel.getCorreoElectronico();
        dao4.agregarHabitaciones(dao.verHotelId(correo), tipo);
    }

}
