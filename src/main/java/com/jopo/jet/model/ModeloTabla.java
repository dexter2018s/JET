package com.jopo.jet.model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.jopo.jet.model.Equipo;

public class ModeloTabla {

    private DefaultTableModel dtm = new DefaultTableModel();
    private ListaEquipos listaEquipos = new ListaEquipos();
    private ArrayList<Equipo> lista = new ArrayList<Equipo>();
    private JTable tabla;
    private final String[] cabecera1 = {"Item", "Descripción", "Cantidad", "Unidad", "Catálogo", "Fabricante"};

    public ModeloTabla() { //constructor
        dtm.setColumnIdentifiers(cabecera1);
        dtm.setColumnCount(cabecera1.length);
    }

    public DefaultTableModel rellenar(ArrayList<Equipo> lista) {

        this.lista = lista;
        Object O[] = null;

        for (int i = 0; i < this.lista.size(); i++) {
            dtm.addRow(O);
            Equipo e = (Equipo) this.lista.get(i);
            this.lista.get(i).setItem(i + 1);
            dtm.setValueAt(e.getItem(), i, 0);
            dtm.setValueAt(e.getDesc(), i, 1);
            dtm.setValueAt(e.getCant(), i, 2);
            dtm.setValueAt(e.getUnd(), i, 3);
            dtm.setValueAt(e.getCat(), i, 4);
            dtm.setValueAt(e.getFab(), i, 5);
        }
        return dtm;
    }

    public DefaultTableModel rellenar() {

        Object O[] = null;
        limpiar(tabla);
        for (int i = 0; i < lista.size(); i++) {
            dtm.addRow(O);
            Equipo e = lista.get(i);
            lista.get(i).setItem(i + 1);//revisar esta parte
            dtm.setValueAt(e.getItem(), i, 0);
            dtm.setValueAt(e.getDesc(), i, 1);
            dtm.setValueAt(e.getCant(), i, 2);
            dtm.setValueAt(e.getUnd(), i, 3);
            dtm.setValueAt(e.getCat(), i, 4);
            dtm.setValueAt(e.getFab(), i, 5);
        }
        return dtm;
    }

    public DefaultTableModel rellenarBase(ArrayList<Equipo> lista) {

        Object O[] = null;
        limpiar(tabla);
        for (int i = 0; i < lista.size(); i++) {
            dtm.addRow(O);
            Equipo e = (Equipo) lista.get(i);
            dtm.setValueAt(e.getItem(), i, 0);
            dtm.setValueAt(e.getDesc(), i, 1);
            dtm.setValueAt(e.getUnd(), i, 2);
            dtm.setValueAt(e.getCat(), i, 3);
            dtm.setValueAt(e.getFab(), i, 4);
            dtm.setValueAt(e.getCod_fab(), i, 5);
        }
        return dtm;
    }

    public DefaultTableModel getModel() {

        return dtm;
    }

    public void setModel(JTable tabla) {
        this.tabla = tabla;
        dtm = (DefaultTableModel) tabla.getModel();
        System.out.println("Se establecio el modelo exitosamente");
    }

    public void setLista(ArrayList<Equipo> lista) {//inicio
        this.lista = lista;
    }//fin

    public void limpiar(JTable tabla) {
        this.tabla = tabla;
        dtm = (DefaultTableModel) this.tabla.getModel();
        int filas = this.tabla.getRowCount();
        for (int i = 0; filas > i; i++) {
            dtm.removeRow(0);
        }

    }

    public void limpiarLista() {
        lista.clear();
    }



//    public void eliminarFila(JTable tabla) {
//        this.tabla = tabla;
//        recogerDatos(this.tabla); //recoge datos de la tabla
////        int[] filas = tabla.getSelectedRows();
////        for (int i = 0; i < filas.length; i++) {
////
////            lista.remove(filas[i] - i);
////
////        }
//        limpiar(tabla);
//        rellenar();
//    }

//    public void agregar(JTable tabla, JTable origen) {
//        this.tabla = tabla;
//        dtm = (DefaultTableModel) tabla.getModel();
//        recogerDatos(this.tabla); //recoge datos de la tabla
//        int[] filas = origen.getSelectedRows();
//
//        for (int i = 0; i < filas.length; i++) {
//
//            int a = (int) origen.getValueAt(filas[i], 0);
//            String b = (String) origen.getValueAt(filas[i], 1);
//            String c = (String) origen.getValueAt(filas[i], 2);
//            String d = (String) origen.getValueAt(filas[i], 3);
//            String e = (String) origen.getValueAt(filas[i], 4);
//            lista.add(new Equipo(a, b, 0.0, c, d, e));
//
//        }
//        limpiar(tabla);
//        rellenar();
//    }

//    public void agregarFila(JTable tabla) {
//        this.tabla = tabla;
//        dtm = (DefaultTableModel) this.tabla.getModel();//obtiene el modelo de tabla
//        recogerDatos(this.tabla); //recoge datos de la tabla
//        limpiar(this.tabla); //limpia toda la tabla
//        Object O[] = null;
//        dtm.addRow(O);
//        Equipo e = new Equipo();
//        e.setItem(lista.size() + 1);
//        lista.add(e);
//        limpiar(this.tabla);
//        rellenar();
//    }

    @Override
    public String toString() {
        System.out.println("La lista tiene tamaño: " + lista.size());
        for (Equipo e : lista) {
            System.out.println(e.getItem() + ", " + e.getDesc() + ", " + e.getCant());
        }
        return "fin lista";
    }

    public DefaultTableModel modeloAscent(ArrayList<Equipo> listado) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulo = {"catalogo", "descripcion", "cantidad", "unidad"};
        modelo.setColumnIdentifiers(titulo);
        modelo.setColumnCount(4);
        Object O[] = null;
        for (int i = 0; i < listado.size(); i++) {
            modelo.addRow(O);
            Equipo e = (Equipo) listado.get(i);
            modelo.setValueAt(e.getCat(), i, 0);
            modelo.setValueAt(e.getDesc(), i, 1);
            modelo.setValueAt(e.getCant(), i, 2);
            modelo.setValueAt(e.getUnd(), i, 3);
        }

        return modelo;
    }
  
}
