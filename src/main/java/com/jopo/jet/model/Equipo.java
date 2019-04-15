package com.jopo.jet.model;

import java.util.Objects;

/**
 *
 * @author Joel
 */
public class Equipo {

    private int item;
    private String desc;
    private double cant;
    private String und;
    private String cat;
    private String fab;
    private String cod_fab;
    private String familia;
    private String sub_familia;

    public Equipo() {
        this.item = 1;
        this.desc = " ";
        this.cant = 0.0;
        this.und = "PZA";
        this.cat = "";
        this.fab = "";
        this.cod_fab = "sin codigo de fabricante";
        this.familia = "";
        this.sub_familia = "";
    }

    public Equipo(int item, String desc, double cant, String und, String cat, String fab) {
        this.item = item;
        this.desc = desc;
        this.cant = 0.0;
        this.und = und;
        this.cat = cat;
        this.fab = fab;
        this.cod_fab = "sin codigo de fabricante";
        this.familia = "";
        this.sub_familia = "";
    }

    public Equipo(int item, String desc, double cant, String und, String cat, String fab, String cod_fab) {
        this.item = item;
        this.cat = cat;
        this.desc = desc;
        this.cant = 0.0;
        this.und = und;
        this.cod_fab = cod_fab;
        this.fab = fab;
        this.familia = "";
        this.sub_familia = "";
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getCant() {
        return cant;
    }

    public void setCant(Double cant) {
        this.cant = cant;
    }

    public String getUnd() {
        return und;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getFab() {
        return fab;
    }

    public void setFab(String fab) {
        this.fab = fab;
    }

    public String getCod_fab() {
        return cod_fab;
    }

    public void setCod_fab(String cod_fab) {
        this.cod_fab = cod_fab;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSub_familia() {
        return sub_familia;
    }

    public void setSub_familia(String sub_familia) {
        this.sub_familia = sub_familia;
    }

    @Override
    public String toString() {
        return "Equipo{" + item + ", " + desc + ", " + cant + ", " + und + ", " + cat + ", " + fab + ", " + cod_fab + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cat);
        hash = 17 * hash + Objects.hashCode(this.cod_fab);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipo other = (Equipo) obj;
        if (other.cat == null) {
            return false;
        }
        if (Objects.equals(this.cat, other.cat)) {
            return true;
        }
        if (Objects.equals(this.cat, other.cod_fab)) {
            return true;
        }
        return false;
    }

}
