/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.Frame;
import java.awt.Color;

/**
 *
 * @author Hoang Trung Duc
 */
public class Event {

    private Frame frame;
    int r = 0, g = 0, b = 0;

    public Event(Frame frame) {
        this.frame = frame;
        frame.panelToChange.setBackground(new Color(0, 0, 0));
        // add 3 event vao day
        frame.sldRed.setValue(0);
        frame.sldRed.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                r = (int) (frame.sldRed.getValue());
                frame.panelToChange.setBackground(new Color(r, g, b));
                frame.txtRed.setText("R = " + r);
            }
        });
        frame.sldBlue.setValue(0);
        frame.sldBlue.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                b = (int) (frame.sldBlue.getValue());
                frame.panelToChange.setBackground(new Color(r, g, b));
                frame.txtBlue.setText("B = " + r);
            }
        });
        frame.sldGreen.setValue(0);
        frame.sldGreen.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                g = (int) (frame.sldGreen.getValue());
                frame.panelToChange.setBackground(new Color(r, g, b));
                frame.txtGreen.setText("G = " + r);
            }
        });
    }

}
