/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.model;

import java.io.File;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joel
 */
public class SeleccionArchivo {
    private Ruta directorio=new Ruta();
    private String filtro;
    public SeleccionArchivo(){
       filtro="csv";
       
    }
    public SeleccionArchivo(String filtro){
       this.filtro=filtro;
       
    }
    
    
    
    
    public String getOutputPath() {
        JFileChooser fileChooser = new JFileChooser(directorio.getRutaEscritorio());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        String ruta="";
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos", this.filtro);
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(fileChooser);

        if (result == JFileChooser.APPROVE_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                System.out.println("No seleccionó nada");
                ruta="";
            } else {
                ruta=fileName.getAbsolutePath();
            }
        }
   
        return ruta;
    }
}
