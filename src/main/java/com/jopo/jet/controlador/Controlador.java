/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.controlador;

import com.jopo.jet.vista.pFrame;

/**
 *
 * @author Joel
 */
public class Controlador {

    private pFrame ventanaPrincipal;
    private Importacion importacion;
    
    public void setVentanaPrincipal(pFrame ventanaPrincipal) {
       this.ventanaPrincipal=ventanaPrincipal;
    }

    public void setImportacion(Importacion importacion) {
        this.importacion=importacion;
    }
    
}
