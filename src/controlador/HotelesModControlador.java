/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.HotelesAdminControlador.formHoteles;
import static controlador.VariablesStaticas.correo;
import dao.CiudadesPaisesDao;
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
import vista.JfrmModificarHotel;

public class HotelesModControlador implements ActionListener{

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
    
    //Controladores a utlizar
    HotelesAdminControlador controlador;

    //ComboBox para los paises
    DefaultComboBoxModel paisesCmb = new DefaultComboBoxModel();

    //Variable de tipo booleana para confirmar si alguno de los radio buttons esta seleccionado
    private boolean confirmarCategorias = false;
    private byte categoria;
    private int contarErroneas;
    private boolean verificacion = false;

    public HotelesModControlador(JfrmModificarHotel vistaMod) {
        this.vistaMod = vistaMod;
        setListeners();
        validarCampos();
        agregarPaises();
        agregarCiudades();
        vistaMod.jCmbCiudadesId.setVisible(false);
        vistaMod.jLblError.setText("");
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
            formHoteles.setEnabled(true);
            formHoteles.toFront();
        }

        if (e.getSource() == vistaMod.jCmbxPaiseMod) {
            agregarCiudades();
        }

        if (e.getSource() == vistaMod.jCmbCiudadesMod) {
            vistaMod.jCmbCiudadesId.setSelectedIndex(vistaMod.jCmbCiudadesMod.getSelectedIndex());
        }
        
        if(e.getSource()==vistaMod.jBtnModificar){
            validarCampos();
            modificarHoteles();
            confirmarCategorias=false;
            vistaMod.dispose();
            controlador= new HotelesAdminControlador(formHoteles);
            controlador.verHoteles();
        }
    }

    public void validarCampos() {
        contarErroneas = 0;
        verificacion = false;
        Validar valid = new Validar();
        valid.ValidarSoloNumeros(vistaMod.jTxtTelefonoMod, 7);
        if (!vistaMod.jTxtCorreoMod.getText().contains("@")
                || !vistaMod.jTxtCorreoMod.getText().contains(".")) {
            vistaMod.jLblError.setText("Correo Invalido");
            contarErroneas++;
        } else {
            vistaMod.jLblError.setText(null);
        }

        if (contarErroneas == 0) {
            verificacion = true;
        }
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

    /*
    *Metodo para cargar el ComboBox de ciudades y el ComboBox de CiudadesId para
    *Modificar
     */
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

    public void tomarDatos() {
        hotel.setNombre(vistaMod.jTxtNombreMod.getText());
        hotel.setCorreoElectronico(vistaMod.jTxtCorreoMod.getText());
        hotel.setTelefono(Integer.parseInt(vistaMod.jTxtTelefonoMod.getText()));
        hotel.setDireccion(vistaMod.jTxtDireccionMod.getText());
        hotel.setCiudad_id(Short.parseShort(String.valueOf(vistaMod.jCmbCiudadesId.getSelectedItem())));

        if (vistaMod.jRbtnCat1Mod.isSelected()) {
            categoria = 101;
        } else if (vistaMod.jRbtnCat2Mod.isSelected()) {
            categoria = 102;
        } else if (vistaMod.jRbtnCat3Mod.isSelected()) {
            categoria = 103;
        } else if (vistaMod.jRbtnCat4Mod.isSelected()) {
            categoria = 104;
        } else if (vistaMod.jRbtnCat5Mod.isSelected()) {
            categoria = 105;
        }
        hotel.setCategoria_id(categoria);
    }

    public void modificarHoteles() {
        if (verificacion == true) {
            tomarDatos();
            JOptionPane.showMessageDialog(vistaMod, dao.modificarHotel(hotel, correo), "Información", JOptionPane.INFORMATION_MESSAGE);
            vistaMod.jTxtNombreMod.requestFocus();
            vistaMod.jLblError.setVisible(false);
        }
    }
}
