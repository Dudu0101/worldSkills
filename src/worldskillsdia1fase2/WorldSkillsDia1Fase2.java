/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldskillsdia1fase2;

import controlador.HotelesAdminControlador;
import vista.JfrmAdminHoteles;

/**
 *
 * @author javam2019
 */
public class WorldSkillsDia1Fase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JfrmAdminHoteles vista= new JfrmAdminHoteles();
        HotelesAdminControlador controlador= new HotelesAdminControlador(vista);
        vista.setVisible(true);
    }
    
}
