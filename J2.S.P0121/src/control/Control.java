/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Hoang Trung Duc
 */
public class Control extends Thread {

    private final Main main;
    private final JPanel panel;
    private final Graphics g;
    private final int xCenter;
    private final int yCenter;

    // set up hand
    static int handS = 90;
    static int handM = 75;
    static int handH = 60;
    static int r = handS + 20;

    public Control(Main main) {
        this.main = main;
        panel = main.panel;
        g = panel.getGraphics();
        // calculate center point
        xCenter = panel.getWidth() / 2;
        yCenter = panel.getHeight() / 2;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            // Calculate
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();
            int minute = now.getMinute();
            int second = now.getSecond();
            draw(second, minute, hour);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void draw(int second, int minute, int hour) {
        double s = second * (2 * Math.PI / 60);
        double m = minute * (2 * Math.PI / 60);
        double h = hour * (2 * Math.PI / 12);
        main.time.setText("Hour: " + hour + " Minute: " + minute + " Second: " + second);
        panel.paintAll(g);
        // draw clock
        
        g.setColor(Color.black);
        g.drawOval(xCenter - r,
                yCenter - r,
                xCenter + r - 15,
                yCenter + r - 15);
        g.drawString("12", xCenter-5, 40);
        g.drawString("6", xCenter, yCenter * 2 - 20);
        g.drawString("9", 30, yCenter);
        g.drawString("3", 2 * xCenter - 30, yCenter);
        // draw second
        g.setColor(Color.red);
        g.drawLine(xCenter,
                yCenter,
                (int) (xCenter + handS * Math.sin(s)),
                (int) (yCenter - handS * Math.cos(s)));
        // draw minute
        g.setColor(Color.blue);
        g.drawLine(xCenter,
                yCenter,
                (int) (xCenter + handM * Math.sin(m)),
                (int) (yCenter - handM * Math.cos(m)));
        // draw hour
        g.setColor(Color.green);
        g.drawLine(xCenter,
                yCenter,
                (int) (xCenter + handH * Math.sin(h)),
                (int) (yCenter - handH * Math.cos(h)));
    }
}
