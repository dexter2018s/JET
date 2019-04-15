/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.model;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Joel
 */
public class ColorearCeldas extends DefaultTableCellRenderer {

    private ArrayList<Integer> itemsError = new ArrayList<Integer>();

    public ColorearCeldas() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //establecemos el fondo blanco o vacío
        setBackground(null);
        //Constructor de la clase DefaultTableCellRenderer
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //Establecemos las filas que queremos cambiar el color. == 0 para pares y != 0 para impares
        boolean oddRow = (row % 2 == 0);

        //Creamos un color para las filas. El 200, 200, 200 en RGB es un color gris
        Color c = new Color(200, 200, 200);

        //Si las filas son pares, se cambia el color a gris
        if (oddRow) {
            setBackground(c);
        }
        return this;
    }

    public void setCellRender(JTable table, ArrayList<Integer> itemsError) {
        this.itemsError=itemsError;
        System.out.println(this.itemsError.toString());
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new ColorearCeldas());
        }
    }

    public void setFilasError(ArrayList<Integer> itemsError) {
        this.itemsError = itemsError;
    }
    
}
