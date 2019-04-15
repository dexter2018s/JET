package com.jopo.jet.main;

import com.jopo.jet.controlador.Controlador;
import com.jopo.jet.vista.pFrame;

/**
 *
 * @author Joel
 */
public class Principal {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        pFrame ventanaPrincipal = new pFrame();
        
        controlador.setVentanaPrincipal(ventanaPrincipal);

       //ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximizado
       ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLocationRelativeTo(null);
System.out.println("primera prueba");
    }
}
