/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.controlador;

import com.jopo.jet.controlador.Controlador;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.jopo.jet.model.ColorearCeldas;
import com.jopo.jet.model.ImportarCSV;
import com.jopo.jet.model.ListaEquipos;
import com.jopo.jet.model.ModeloTabla;
import com.jopo.jet.model.Progreso;
import com.jopo.jet.model.SeleccionArchivo;

/**
 *
 * @author Joel
 */
public class Importacion {

    private Controlador controlador = new Controlador();
    private ListaEquipos listaBorrador = new ListaEquipos();
    private ModeloTabla mdBorrador = new ModeloTabla();
    private JTable tbBorrador = new JTable();
    private JTextField txtTotalImportados = new JTextField();
    private JTextField txtFilasError = new JTextField();
    private JTextField txtCantTotal = new JTextField();
    private ColorearCeldas colorearCeldas = new ColorearCeldas();
    private JLabel txtCargando;
    private JLabel txtPorcentaje;
    private JProgressBar pb;

    public Importacion(JTable tbBorrador, JTextField txtTotalImportados,
            JTextField txtFilasError, JLabel txtCargando, JLabel txtPorcentaje, JProgressBar jProgressBar1, JTextField txtCantTotal) {

        this.tbBorrador = tbBorrador;
        this.txtTotalImportados = txtTotalImportados;
        this.txtFilasError = txtFilasError;
        this.txtCargando = txtCargando;
        this.txtPorcentaje = txtPorcentaje;
        this.pb = jProgressBar1;
        this.txtCantTotal = txtCantTotal;

    }

    public void ejecutar() {

        SeleccionArchivo sa = new SeleccionArchivo();
        String ruta = sa.getOutputPath();
        if (!ruta.equals("")) {//validacion de ruta obtenida
            txtCargando.setVisible(true);
            txtPorcentaje.setVisible(true);
            pb.setVisible(true);
            txtCargando.setText("Importando...");
            ImportarCSV importador = new ImportarCSV(ruta);
            ArrayList<String> s = importador.getListaString(); //se obtiene un Arreglo de String
            listaBorrador.limpiar();//se limpia la lista actual
            listaBorrador.recogerDatos(tbBorrador); //respalda los datos de la tabla en una lista

            boolean error2 = listaBorrador.listaStringToEquipos(s); //convierte String a Listado de Equipos
            System.out.println(listaBorrador.toString());
            if (error2 == true) {
                txtCargando.setText("Importacion fallida");
            } else {
                txtCargando.setText("Importacion completada");
            }

            txtTotalImportados.setText("" + listaBorrador.size()); //muestra el total de importados
            txtCantTotal.setText("" + listaBorrador.calcularCantTotal());
            txtFilasError.setText(listaBorrador.getItemsError().toString());
            //colorearCeldas.setCellRender(tbBorrador, listaBorrador.getItemsError());
            mdBorrador.setModel(tbBorrador); //se respalda el modelo para no perder el ancho de las columnas
            mdBorrador.setLista(listaBorrador.getLista()); //añade los datos importados
            mdBorrador.rellenar();
            tbBorrador.setModel(mdBorrador.getModel());

            pb.setVisible(false);
            txtPorcentaje.setVisible(false);
        }
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
