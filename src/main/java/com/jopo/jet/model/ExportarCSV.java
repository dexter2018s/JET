package com.jopo.jet.model;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel
 */
public class ExportarCSV {

    private List<String[]> datos = new ArrayList<String[]>();
    private String ruta;
    private final String[] titulo = {"LISTA DE MATERIALES", "", "", "", "", ""};
    private final String[] cabecera = {"ITEM", "DESCRIPCIÓN", "CANT.", "UNID.", "CATÁLOGO", "FABRICANTE"};

    public ExportarCSV(String ruta, ArrayList<Equipo> datos) {
        this.datos.clear();
        this.datos.add(titulo);
        this.datos.add(cabecera);
        setDatos(datos);
        this.ruta = ruta;
    }

    public void setDatos(ArrayList<Equipo> datos) {
        int i = 0;
        for (Equipo e : datos) {
            String[] s = {"" + e.getItem(), e.getDesc(), "" + e.getCant(), e.getUnd(), e.getCat(), e.getFab()};
            this.datos.add(s);
        }
    }

    public void exportar(String ruta) throws IOException {

        //CSVWriter writer = new CSVWriter(new FileWriter(ruta), ';');
        CSVWriter writer = new CSVWriter(new FileWriter(ruta),';' , CSVWriter.DEFAULT_QUOTE_CHARACTER, 
                CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        writer.writeAll(datos);
        writer.close();

    }

}
