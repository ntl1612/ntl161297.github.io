/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import bo.PuzzleButton;
import control.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Trinh the hoan
 */
public class ButtonManager implements ActionListener {

    public PuzzleButton[][] matrixButton;
    int length = 0;
    private final Controller controller;

    public ButtonManager(int size, Controller controller) {
        this.controller = controller;
        matrixButton = new PuzzleButton[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixButton[i][j] = new PuzzleButton(i, j);
                matrixButton[i][j].number = (i) * size + (j + 1);
                matrixButton[i][j].setText(matrixButton[i][j].number + "");
                matrixButton[i][j].addActionListener((ActionListener) this);
            }
        }
        matrixButton[size - 1][size - 1].setText("");
        length = size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = 0, y = 0;
        int x2 = 0, y2 = 0;
        String name = e.getActionCommand();
        if (name.equalsIgnoreCase("")) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrixButton[i][j].getText().equals(name)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrixButton[i][j].getText().equals("")) {
                    x2 = i;
                    y2 = j;
                    break;
                }
            }
        }
        if (check(x, y, x2, y2)) {
            String temp = matrixButton[x][y].getText();
            matrixButton[x][y].setText(matrixButton[x2][y2].getText());
            matrixButton[x2][y2].setText(temp);
            controller.count++;
            controller.changeCount();
        }

        if (end()) {
            Controller.cTime.suspend();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    matrixButton[i][j].setEnabled(false);
                }
            }
            JOptionPane.showMessageDialog(null, "You win!");
        }

    }

    public void mixAll(int n) {
        int x = 0, y = 0;
        int x2 = 0, y2 = 0;
        String name;
        if (n == 0) {
            return;
        } else {
            name = n + "";
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrixButton[i][j].getText().equals(name)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrixButton[i][j].getText().equals("")) {
                    x2 = i;
                    y2 = j;
                    break;
                }
            }
        }
        if (check(x, y, x2, y2)) {
            String temp = matrixButton[x][y].getText();
            matrixButton[x][y].setText(matrixButton[x2][y2].getText());
            matrixButton[x2][y2].setText(temp);
        } 
    }

    boolean check(int x, int y, int x2, int y2) {
        if (x == x2 && y == y2 - 1) {
            return true;
        }
        if (x == x2 && y == y2 + 1) {
            return true;
        }
        if (x == x2 + 1 && y == y2) {
            return true;
        }
        return x == x2 - 1 && y == y2;
    }

    boolean end() {
        for (int i = 0; i < length * length - 1; i++) {
            if (!matrixButton[i / length][i % length].getText().equals((i + 1) + "")) {
                return false;
            }
        }
        return true;
    }
}
