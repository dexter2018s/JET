/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.model;

import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public class FilaError {

    private ArrayList<Integer> itemsError = new ArrayList<Integer>();

    public FilaError(ArrayList<Integer> itemsError) {
        this.itemsError = itemsError;
    }
}
