/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.model;

/**
 *
 * @author Joel
 */
public class Ruta {
    
    private String ruta;
    
    public String getRutaEscritorio(){
 
        ruta=System.getProperty("user.home")+"\\Desktop";
        return ruta;
    }
}
