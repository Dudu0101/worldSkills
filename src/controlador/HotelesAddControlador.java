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
import javax.swing.DefaultComboBoxModel;
import modelo.Ciudades_Paises;
import modelo.Hoteles;
import modelo.Paises;
import vista.JfrmAddHotel;

/**
 *
 * @author javam2019
 */
public class HotelesAddControlador implements ActionListener{

    Hoteles hotel = new Hoteles();
    Paises paises = new Paises();
    Ciudades_Paises cidpas= new Ciudades_Paises();
    

    
    HotelesDao dao = new HotelesDao();
    PaisesDao dao2 = new PaisesDao();
    CiudadesPaisesDao dao3= new CiudadesPaisesDao();
    DefaultComboBoxModel paisesAdd= new DefaultComboBoxModel();
    
    JfrmAddHotel addHotel;

    public HotelesAddControlador(JfrmAddHotel addHotel) {
        this.addHotel = addHotel;
        setActionsListeners();
        validarCampos();
        llenarPaisesHoteles();
    }
    
    /*
    *Metodo para agregar action listeners a los campos
    */
    public void setActionsListeners(){
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
    
    /*
    *Metodo para llenar el comboBox de países
    */
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addHotel.jCmbxPaiseHotel){
            llenarCiudadesHoteles();
        }
    }
    
    public void validarCampos(){
        Validar valid= new Validar();
        valid.ValidarSoloLetras(addHotel.jTxtNombreHotel);
        valid.ValidarSoloNumeros(addHotel.jTxtTelefonoHotel, 7);   
    }
    
    //Metodo para llenar el ComboBox de Paises
    public void llenarPaisesHoteles() {
        for (Paises pais : dao2.verPaises()) {
            paisesAdd.addElement(pais.getNombre());
        }
        addHotel.jCmbxPaiseHotel.setModel(paisesAdd);
    }
    
    //Metodo para llenar el ComboBox de Ciudades dependiendo el pais
    public void llenarCiudadesHoteles() {
        DefaultComboBoxModel verCiudades = new DefaultComboBoxModel();
        cidpas.setPais(String.valueOf(addHotel.jCmbxPaiseHotel.getSelectedItem()));
        for (Ciudades_Paises cidpas : dao3.verCiudades(cidpas)) {
            verCiudades.addElement(cidpas.getCiudad());
        }
        addHotel.jCmbCiudadesHotel.setModel(verCiudades);
    }

}
