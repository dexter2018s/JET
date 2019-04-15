package com.jopo.jet.model;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Joel
 */
public class ListaEquipos {

    private ArrayList<Equipo> lista = new ArrayList<Equipo>();
    private ArrayList<Integer> itemsError = new ArrayList<Integer>();
    private int i;
    private int cantError;
    private double cantTotal;

    //constructor
    public ListaEquipos() {
        i = 1;
        itemsError.clear();
        cantError = 0;
        cantTotal = 0;
    }//fin constructor

    //devuelve una lista de equipos que no forman parte de la lista1
    public ArrayList<Equipo> encontrarFaltantes(ArrayList<Equipo> lista1, ArrayList<Equipo> lista2) {
        boolean flag = false;
        limpiar();
        lista = lista1;
        System.out.println("METODO LISTA 1");
        System.out.println(lista1.toString());
        System.out.println("METODO LISTA 2");
        System.out.println(lista.toString());
        flag = lista.removeAll(lista2);//elimina de la lista1 los elementos de la lista2

        System.out.println(" METODO FALTANTES");
        System.out.println(lista.toString());

        return lista;

    }//fin

    //metodo para convertir una lista de String a lista de equipos validando
    //las cantidades
    public boolean listaStringToEquipos(ArrayList<String> listaString) {//inicio
        try {
            String[] dato;
            cantError = 0;
            for (String s : listaString) {//por cada String de la lista
                s = s.replaceAll("\"", "");
                dato = s.split(";");
                Equipo e = new Equipo();
                e.setItem(i);
                e.setDesc(dato[1]);
                e.setCant(validarCantidad(dato[2])); //validacion de cantidad
                e.setUnd(dato[3]);
                e.setCat(dato[4]);
                e.setFab(dato[5]);
                lista.add(e);
                i++;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Listado de equipos no valido");
            return true;
        }

        return false;
    }//fin

    public boolean recogerDatos(JTable tabla) {

        int filas = tabla.getRowCount();
        try {
            for (int i = 0; i < filas; i++) {
                Equipo e = new Equipo();
                e.setItem((int) tabla.getValueAt(i, 0));
                e.setDesc((String) tabla.getValueAt(i, 1));
                Double temporal = (Double) tabla.getValueAt(i, 2);
                e.setCant(temporal);
                e.setUnd((String) tabla.getValueAt(i, 3));
                e.setCat((String) tabla.getValueAt(i, 4));
                e.setFab((String) tabla.getValueAt(i, 5));
                lista.add(e);
                actualizar();

            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }

    //valida la columna Cantidad
    public double validarCantidad(String cant) {
        double datoCantidad = 0.0;

        try {
            datoCantidad = Double.parseDouble(cant);
        } catch (NumberFormatException ex) {
            itemsError.add(i);
            cantError++;
        }
        return datoCantidad;
    }

    public ArrayList<Equipo> totalizar() {//inicio

        ArrayList<Equipo> listaTotal = new ArrayList<Equipo>();
        double cant = 0;
        for (int i = 0; i < lista.size(); i++) {
            String catalogo = lista.get(i).getCat();
            int bandera = 0;

            //validacion si el catalogo ya se añadio a listaTotal
            for (int k = 0; k < listaTotal.size(); k++) {

                if (listaTotal.get(k).getCat().equals(catalogo)) {
                    bandera++;
                }
            }

            //si el catalogo aun no fue añadido se totaliza
            if (bandera == 0) {
                for (int j = 0; j < lista.size(); j++) {
                    String catTemp = lista.get(j).getCat();
                    double cantTemp = lista.get(j).getCant();

                    if (catalogo.equals(catTemp)) {
                        cant = cantTemp + cant;
                    }
                }
                lista.get(i).setCant(cant);
                listaTotal.add(lista.get(i));
                cant = 0;
            }
        }
        limpiar();
        lista = listaTotal;
        actualizar();
        return listaTotal;
    }//fin

    public ArrayList<Equipo> buscarCantidadPorCatalogo(ArrayList<Equipo> listaTotal) {

        for (Equipo e1 : listaTotal) {

            for (Equipo e2 : lista) {

                if (e1.equals(e2)) {

                    e2.setCant(e1.getCant());

                }
            }
        }

        return lista;
    }

    public int size() {
        return lista.size();
    }

    @Override
    public String toString() {
        for (Equipo e : lista) {
            System.out.println(e.toString());
        }
        return "Fin";
    }

    //limpiar el ArrayList y pone los errores en cero, ademas de poner en 1 item
    public boolean limpiar() {
        lista.clear();
        i = 1;
        cantError = 0;
        itemsError.clear();
        return true;
    }

    //eliminar los equipos seleccionados en la tabla. Para posteriormente
    //eliminarlos de la tabla
    public void eliminarEquipo(JTable tabla) {
        System.out.println("LISTA: ");
        System.out.println(lista.toString());
        int[] filas = tabla.getSelectedRows();
        System.out.println(Arrays.toString(filas));
        for (int j = 0; j < filas.length; j++) {
            lista.remove(filas[j] - j);
            actualizar();
        }
    }

    public void agregarEquipo(JTable tabla) {
        System.out.println("LISTA: ");
        System.out.println(lista.toString());
        int[] filas = tabla.getSelectedRows();
        System.out.println("Lista seleccionada");
        System.out.println(Arrays.toString(filas));
        for (int j = 0; j < filas.length; j++) {
            Equipo e = new Equipo();
            e.setItem((int) tabla.getValueAt(filas[j], 0));
            e.setDesc((String) tabla.getValueAt(filas[j], 1));
            e.setUnd((String) tabla.getValueAt(filas[j], 2));
            e.setCat((String) tabla.getValueAt(filas[j], 3));
            e.setFab((String) tabla.getValueAt(filas[j], 4));      
            lista.add(e);
            actualizar();
        }
    }

    public void actualizar() {
        i = 1;
        for (Equipo e : lista) {
            e.setItem(i);
            i++;
        }
    }

    public void agregarFila() {
        Equipo e = new Equipo();
        lista.add(e);
        actualizar();
    }

    public void add(Equipo e) {
        lista.add(e);
        actualizar();
    }

    public double calcularCantTotal() {
        cantTotal = 0;
        for (Equipo e : lista) {
            cantTotal = cantTotal + e.getCant();
        }
        cantTotal = (double) Math.round(cantTotal * 100) / 100;

        return cantTotal;
    }

    public ArrayList<Integer> getItemsError() {
        return itemsError;
    }

    public int getCantError() {
        return cantError;
    }

    public ArrayList<Equipo> getLista() {
        return lista;
    }
    
    public Equipo getEquipo(int i) {
        return lista.get(i);
    }

    public void setLista(ArrayList<Equipo> lista) {
        this.lista = lista;
        i = this.lista.size() + 1;
    }

}
