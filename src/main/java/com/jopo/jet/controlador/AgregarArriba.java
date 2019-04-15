/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.jopo.jet.model.ListaEquipos;
import com.jopo.jet.model.ModeloTabla;

/**
 *
 * @author Joel
 */
public class AgregarArriba {

    private ListaEquipos lista = new ListaEquipos();
    private JTable tabla = new JTable();
    private JTable tablaBase = new JTable();
    private ModeloTabla md = new ModeloTabla();
    private JTextField txtTotalImportados;
    private JTextField txtFilasError;
    private JTextField txtCantTotal = new JTextField();

    //contructor
    public AgregarArriba(JTable tabla, JTable tablaBase, JTextField txtTotalImportados, JTextField txtFilasError, JTextField txtCantTotal) {
        this.tabla = tabla;
        this.tablaBase = tablaBase;
        this.txtTotalImportados = txtTotalImportados;
        this.txtFilasError = txtFilasError;
        this.txtCantTotal = txtCantTotal;
    }//fin constructor

    public void ejecutar() {

        lista.limpiar();//se limpia la lista actual
        System.out.println("LISTA ANTERIOR");
        System.out.println(lista.toString());
        lista.recogerDatos(tabla);//se respalda la lista en String
        lista.agregarEquipo(tablaBase);//agrega una fila vacia
        System.out.println("Lista recogida:");
        System.out.println(lista.toString());
        txtTotalImportados.setText("" + lista.size()); //muestra el total de importados
        txtFilasError.setText(lista.getItemsError().toString());//muestra las filas en error de cantidad
        txtCantTotal.setText("" + lista.calcularCantTotal());
        //colorearCeldas.setCellRender(tbBorrador, listaBorrador.getItemsError());
        md.setModel(tabla); //se respalda el modelo para no perder el ancho de las columnas
        md.setLista(lista.getLista()); //añade los datos importados
        md.rellenar();
        tabla.setModel(md.getModel());
    }

}
