/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jopo.jet.model;

import java.util.List;
import javafx.scene.control.ProgressBar;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Joel
 */
public class Progreso extends SwingWorker<Double, Integer> {
    private ProgressBar pb=new ProgressBar();
    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());
        //proceso pesado o lento
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            // Se pasa valor para la barra de progreso. Esto llamara al metodo
            // process() en el hilo de despacho de eventos.
            publish(i + 1);
        }

        // Supuesto resultado de la tarea que tarda mucho.
        return 100.0;
    }

    // Esta JProgressBar la recibiremos en el constructor o en
    // un parametro setProgreso()
    private JProgressBar progreso;

    @Override
    protected void process(List<Integer> chunks) {
        System.out.println("process() esta en el hilo "
                + Thread.currentThread().getName());
        //pb.setValue(chunks.get(0));
    }

}
