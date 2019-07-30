/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CiudadesPaisesDao;
import dao.HotelesDao;
import dao.PaisesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class HotelesAddControlador implements ActionListener {

    Hoteles hotel = new Hoteles();
    Paises paises = new Paises();
    Ciudades_Paises cidpas = new Ciudades_Paises();

    ArrayList<Ciudades_Paises> lista = new ArrayList();

    HotelesDao dao = new HotelesDao();
    PaisesDao dao2 = new PaisesDao();
    CiudadesPaisesDao dao3 = new CiudadesPaisesDao();
    DefaultComboBoxModel paisesAdd = new DefaultComboBoxModel();
    //llenar el combo de pais id
    DefaultComboBoxModel paisesIdAdd = new DefaultComboBoxModel();

    JfrmAddHotel addHotel;

    public HotelesAddControlador(JfrmAddHotel addHotel) {
        this.addHotel = addHotel;
        setActionsListeners();
        validarCampos();
        llenarPaisesHoteles();
        llenarCiudadesHoteles();
    }

    /*
    *Metodo para agregar action listeners a los campos
     */
    public void setActionsListeners() {
        addHotel.jBtnGuardar.addActionListener(this);
        addHotel.jBtnCancelar.addActionListener(this);
        addHotel.jCmbxPaiseHotel.addActionListener(this);
        addHotel.jCmbCiudadesHotel.addActionListener(this);
        addHotel.jRbtnCat1.addActionListener(this);
        addHotel.jRbtnCat2.addActionListener(this);
        addHotel.jRbtnCat3.addActionListener(this);
        addHotel.jRbtnCat4.addActionListener(this);
        addHotel.jRbtnCat5.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addHotel.jCmbxPaiseHotel) {
            llenarCiudadesHoteles();
        }

        if (e.getSource() == addHotel.jCmbCiudadesHotel) {
            addHotel.jCmbCiudadesHotel1.setSelectedIndex(addHotel.jCmbCiudadesHotel.getSelectedIndex());

        }

        if (e.getSource() == addHotel.jBtnGuardar) {
            borrarCajas();
            addHotel.jTxtNombreHotel.requestFocus();
            JOptionPane.showMessageDialog(addHotel, addHotel.jCmbCiudadesHotel1.getSelectedItem());
        }
    }

    /*
    *Método para agregar validacion a los campos
     */
    public void validarCampos() {
        Validar valid = new Validar();
        valid.ValidarSoloLetras(addHotel.jTxtNombreHotel);
        valid.ValidarSoloNumeros(addHotel.jTxtTelefonoHotel, 7);
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
        addHotel.jCmbxPaiseHotel1.setModel(paisesIdAdd);
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
        addHotel.jCmbCiudadesHotel1.setModel(verCiudadesId);
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

    }

    /*
    *Método para agregar los Hoteles a la base de datos
     */
    public void agregarHoteles() {

    }

}
