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
    
    JfrmAddHotel addHotel;

    public HotelesAddControlador(JfrmAddHotel addHotel) {
        this.addHotel = addHotel;
        setActionsListeners();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
