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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Ciudades_Paises;
import modelo.Hoteles;
import modelo.Paises;
import vista.JfrmModificarHotel;

public class HotelesModControlador implements ActionListener, KeyListener {

    //MOdelos a utilizar
    Hoteles hotel = new Hoteles();
    Paises paises = new Paises();
    Ciudades_Paises ciudades = new Ciudades_Paises();

    ArrayList<Ciudades_Paises> lista = new ArrayList();

    HotelesDao dao = new HotelesDao();
    PaisesDao dao2 = new PaisesDao();
    CiudadesPaisesDao dao3 = new CiudadesPaisesDao();

    //Formulario a utilizar
    JfrmModificarHotel vistaMod;

    //ComboBox para los paises
    DefaultComboBoxModel paisesCmb = new DefaultComboBoxModel();

    private byte categoria;

    public HotelesModControlador(JfrmModificarHotel vistaMod) {
        this.vistaMod = vistaMod;
        setListeners();
        agregarPaises();
        agregarCiudades();
    }

    public void setListeners() {

        //Botones
        vistaMod.jBtnModificar.addActionListener(this);
        vistaMod.jBtnCancelarMod.addActionListener(this);

        //Combo Box
        vistaMod.jCmbxPaiseMod.addActionListener(this);
        vistaMod.jCmbCiudadesMod.addActionListener(this);

        //Radio Buttons
        vistaMod.jRbtnCat1Mod.addActionListener(this);
        vistaMod.jRbtnCat2Mod.addActionListener(this);
        vistaMod.jRbtnCat3Mod.addActionListener(this);
        vistaMod.jRbtnCat4Mod.addActionListener(this);
        vistaMod.jRbtnCat5Mod.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMod.jBtnCancelarMod) {
            vistaMod.dispose();
        }
        if (e.getSource() == vistaMod.jCmbxPaiseMod) {
            agregarCiudades();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    *Metodo para agregar los paises al combo Box correspondiente
     */
    public void agregarPaises() {
        for (Paises pais : dao2.verPaises()) {
            paisesCmb.addElement(pais.getNombre());
        }
        vistaMod.jCmbxPaiseMod.setModel(paisesCmb);
    }

    public void agregarCiudades() {
        DefaultComboBoxModel ciudadesCmb = new DefaultComboBoxModel();
        DefaultComboBoxModel ciudadesCmbId = new DefaultComboBoxModel();

        ciudades.setPais(String.valueOf(vistaMod.jCmbxPaiseMod.getSelectedItem()));
        for (Ciudades_Paises verCiudade : dao3.verCiudades(ciudades)) {
            ciudadesCmb.addElement(verCiudade.getCiudad());
            ciudadesCmbId.addElement(verCiudade.getCiudad_id());
        }
        vistaMod.jCmbCiudadesMod.setModel(ciudadesCmb);
        vistaMod.jCmbCiudadesId.setModel(ciudadesCmbId);
    }

}
