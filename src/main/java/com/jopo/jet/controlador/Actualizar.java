/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.controlador;

import javax.swing.JTable;
import javax.swing.JTextField;
import com.jopo.jet.model.ListaEquipos;
import com.jopo.jet.model.ModeloTabla;

/**
 *
 * @author Joel
 */
public class Actualizar {
    private ListaEquipos lista = new ListaEquipos();
    private JTable tabla = new JTable();
    private ModeloTabla md = new ModeloTabla();
    private JTextField txtTotalImportados;
    private JTextField txtFilasError;
    private JTextField txtCantTotal = new JTextField();
    
    //contructor
    public Actualizar(JTable tabla,JTextField txtTotalImportados,JTextField txtFilasError, JTextField txtCantTotal) {
        this.tabla = tabla;
        this.txtTotalImportados=txtTotalImportados;
        this.txtFilasError=txtFilasError;
        this.txtCantTotal=txtCantTotal;
    }//fin constructor

    
    public void ejecutar() {
        lista.limpiar();//se limpia la lista actual
        lista.recogerDatos(tabla);//se respalda la lista en String
        txtTotalImportados.setText("" + lista.size()); //muestra el total de importados
        txtFilasError.setText(lista.getItemsError().toString());//muestra las filas en error de cantidad
        txtCantTotal.setText("" + lista.calcularCantTotal());
    }
}
