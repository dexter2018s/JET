/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.controlador;

import com.jopo.jet.model.Servicios;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.jopo.jet.model.Equipo;
import com.jopo.jet.model.ListaEquipos;
import com.jopo.jet.model.ModeloTabla;

/**
 *
 * @author Joel
 */
public class Totalizar {

    private ListaEquipos lista = new ListaEquipos();
    private ListaEquipos listaEncontrados = new ListaEquipos();
    private ListaEquipos listaFaltantes = new ListaEquipos();
    private JTable tbBorrador = new JTable();
    private ModeloTabla md = new ModeloTabla();
    private JTextField txtTotalImportados;
    private JTextField txtFilasError;
    private JTextField txtCantTotal = new JTextField();
    private JTable tbFaltantes;
    private JTable tbListado;
    private ListaEquipos listaTemporal = new ListaEquipos();

    //contructor
    public Totalizar(JTable tbBorrador, JTable tbFaltantes, JTable tbListado,
            JTextField txtTotalImportados, JTextField txtFilasError, JTextField txtCantTotal) {
        this.tbBorrador = tbBorrador;
        this.tbFaltantes = tbFaltantes;
        this.tbListado = tbListado;
        this.txtTotalImportados = txtTotalImportados;
        this.txtFilasError = txtFilasError;
        this.txtCantTotal = txtCantTotal;
    }//fin constructor

    public void ejecutar() {
        lista.limpiar(); //se borra todos los equipos de la lista Borrador
        lista.recogerDatos(tbBorrador); //se recoge los datos de la tabla Borrador
        lista.recogerDatos(tbListado); //se recoge los datos de la tabla Borrador
        lista.totalizar();
        System.out.println("LISTA TOTALIZADA");
        System.out.println(lista.toString());
//        ArrayList<Equipo> listaEncontrados = new ArrayList<Equipo>();
//        ArrayList<Equipo> listaFaltantes = new ArrayList<Equipo>();
//
//        listaTotalizada = cTotalizados.totalizar();
        Servicios servicio = new Servicios();
        int i = 0;
        try {
            for (Equipo e : lista.getLista()) {
                ResultSet rs = servicio.buscarPorCatalogo(e.getCat());

                while (rs.next()) {
                    Equipo eq = new Equipo();
                    i++;
                    eq.setItem(i);
                    eq.setCat(rs.getString("CODIGO"));
                    eq.setDesc(rs.getString("NOMBRE"));
                    eq.setUnd(rs.getString("UNIDAD"));
                    eq.setFab(rs.getString("MARCA"));
                    eq.setCod_fab(rs.getString("CODIGO_FAB"));
                    eq.setFamilia(rs.getString("FAMILIA"));
                    eq.setSub_familia(rs.getString("SUB_FAMILIA"));
                    listaTemporal.add(eq);
                }
                System.out.println("Cantidad de equipos encontrados en la base: " + listaTemporal.size());
                if (listaTemporal.size()<2) {
                    for (int j = 0; j < listaTemporal.size(); j++) {
                        listaEncontrados.add(listaTemporal.getEquipo(j));
                    }
                }
                listaTemporal.limpiar();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Estos fueron encontrados en la base: ");
        System.out.println(listaEncontrados.toString());
        listaEncontrados.buscarCantidadPorCatalogo(lista.getLista()); //actualiza las cantidades
        double cantLista = lista.calcularCantTotal();
        System.out.println("LISTA ENCONTRADOS");
        System.out.println(listaEncontrados.getLista());
        listaFaltantes.encontrarFaltantes(lista.getLista(), listaEncontrados.getLista());
        System.out.println("LISTA ENCONTRADOS");
        System.out.println(listaEncontrados.getLista());
        System.out.println(listaEncontrados.calcularCantTotal());
        JOptionPane.showMessageDialog(null, "Cantidad Borrador: " + cantLista + "\n"
                + "Cantidad Encontrados: " + listaEncontrados.calcularCantTotal() + "\n"
                + "Cantidad Faltantes: " + listaFaltantes.calcularCantTotal());

        md.setModel(tbFaltantes); //se respalda el modelo para no perder el ancho de las columnas
        md.setLista(listaFaltantes.getLista()); //añade los datos importados
        md.rellenar();
        tbFaltantes.setModel(md.getModel());
        md.setModel(tbListado); //se respalda el modelo para no perder el ancho de las columnas
        //md.limpiar(tbListado);
        md.setLista(listaEncontrados.getLista()); //añade los datos importados
        md.rellenar();
        tbListado.setModel(md.getModel());
    }

}
