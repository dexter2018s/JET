package com.jopo.jet.model;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Progress extends SwingWorker<Integer, String>{
    
    JLabel label;
    JProgressBar jpbar;

    public Progress(JLabel label, JProgressBar jpbar) {
        this.label = label;
        this.jpbar = jpbar;
    }
    
    
    
    
    @Override
    protected Integer doInBackground() throws Exception {
       
       
       return 0;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JProgressBar getJpbar() {
        return jpbar;
    }

    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }
    
    
}
