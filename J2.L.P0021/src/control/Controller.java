/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import event.ButtonManager;
import gui.Puzzle;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Trinh the hoan
 */
public class Controller {

    private final Puzzle xepHinh;
    private ButtonManager ql;
    private static final JLabel lblCount = new JLabel("Move Count: 0");
    private static final JLabel lblTime = new JLabel("Elapsed: 0");
    public int count = 0;
    static int time = 0;
    public int height = 0;
    public int weight = 0;
    int option = 7;
    int size;

    // creat game screen
    public Controller(Puzzle xepHinh) {
        this.xepHinh = xepHinh;
        xepHinh.pnMove.setLayout(new GridLayout(1, 1));
        xepHinh.pnTime.setLayout(new GridLayout(1, 1));
        xepHinh.pnMove.add(lblCount);
        xepHinh.pnTime.add(lblTime);
    }

    //set text move count
    public void changeCount() {
        lblCount.setText("Count: " + count);
    }

    //insert hard options
    public void insert() {
        for (int i = 0; i < option; i++) { //loop to insert each option
            int size = i + 3;
            xepHinh.sizeCbb.insertItemAt(size + " x " + size, i);
        }
        xepHinh.sizeCbb.setSelectedIndex(0);
    }

    //creat new game
    public void createTT() {
        size = xepHinh.sizeCbb.getSelectedIndex();
        if (cTime.isAlive()) {
            time =0;
            cTime.resume();
        } else {
            time = 0;
            cTime.start();
            size = xepHinh.sizeCbb.getSelectedIndex();
        }

        create(size + 3);
    }

    public void show1(JFrame jFrame) {
        jFrame.setBounds(0, 0, weight + 50, height + 200);
        jFrame.setLocationRelativeTo(null);
    }

    public void create(int length) {
        ql = new ButtonManager(length, this);
        xepHinh.panelPuzzle.removeAll();
        weight = height = length * 50 + 10;
        xepHinh.panelPuzzle.setPreferredSize(new Dimension(weight, height));
        xepHinh.panelPuzzle.setLayout(new GridLayout(length, length));
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                xepHinh.panelPuzzle.add(ql.matrixButton[i][j]);
            }
        }
        count = 0;
        lblCount.setText("Move Count: " + count);
        rdm(length);
    }

    void rdm(int size) {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int n = r.nextInt(size * size);
            ql.mixAll(n);
        }

    }
    public void pause(){
        cTime.suspend();
    }
     public void resume(){
        cTime.resume();
    }
    public static final countTime cTime = new countTime();

    public static class countTime extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                    lblTime.setText("Elapsed: " + time++);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
