package com.jopo.jet.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * //
 *
 *
 * @author Joel
 */
public class ImportarCSV {

    private ArrayList<String> listaStringInicial= new ArrayList<String>();
    private ArrayList<String> listaStringFinal= new ArrayList<String>();
    private String linea;
    private String ruta;

    public ImportarCSV(String ruta) {
        this.ruta = ruta;
        System.out.println(ruta);
        importarCSV();
    }

    public void importarCSV() {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.ruta));
            do {
                linea = br.readLine(); //leer una linea de texto
                listaStringInicial.add(linea);
            } while (null != linea);//mientras no exista linea vacia entonces
            br.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se puedo crear el archivo en la ruta indicada. Detalle: " + e);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema al leer el archivo. Detalle: " + ex);
        }

    }//fin

    public ArrayList<String> getListaString() { //especifico para esta aplicacion
        
        int cont = 0;
        int j = 0;
        while (j < listaStringInicial.size() - 1) {
            String cadena = listaStringInicial.get(j);

            if (cadena.length() != 0) {
                listaStringFinal.add(cadena);
                cont++;
            } else {
                String temporal = listaStringInicial.get(j - 1) + listaStringInicial.get(j + 1);
                listaStringInicial.remove(j);
                listaStringFinal.remove(cont - 1);
                listaStringFinal.add(temporal);
            }
            j++;

        }
        listaStringFinal.remove(0);
        listaStringFinal.remove(0);
        return listaStringFinal;
    }

    public ArrayList<String> getListaStringInicial() {
        return listaStringInicial;
    }

    public ArrayList<String> getListaStringFinal() {
        return listaStringFinal;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
