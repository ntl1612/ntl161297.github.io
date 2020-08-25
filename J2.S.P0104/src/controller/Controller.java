/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.DataTable;

/**
 *
 * @author Thanh Long Nguyen
 */
public class Controller {

    DataTable dt;
    int count;

    public Controller(DataTable dt) {
        this.dt = dt;
        count = dt.dataTable.getRowCount(); //count the number of rows
    }

    public DataTable getDataTable() {
        return dt;
    }

//create function Move first
    public void moveFirst() {
        //set the current row to the first row
        dt.dataTable.setRowSelectionInterval(0, 0);
    }

//create function move last
    public void moveLast() {
        // set the current row to the last row
        dt.dataTable.setRowSelectionInterval(count - 1, count - 1);
    }

//create function Move previous
    public void movePrevious() {
        //get the current row
        int currentIndex = dt.dataTable.getSelectedRow();
        //get the previous row
        currentIndex--;
        //if current row is the first row, move to the last row 
        if (currentIndex < 0) {
            moveLast();
        } else {
            //set the current row to the previous row
            dt.dataTable.setRowSelectionInterval(currentIndex, currentIndex);
        }
    }

//create function Move next
    public void moveNext() {
        //get the current row
        int currentIndex = dt.dataTable.getSelectedRow();
        //get the next row
        currentIndex++;
        //if the current row is the last row, move to the first row
        if (currentIndex == count) {
            moveFirst();
        } else {
            //set the current row to the next row
            dt.dataTable.setRowSelectionInterval(currentIndex, currentIndex);
        }
    }

//create function action for all buttons
    public void action() {
        dt.setVisible(true);
        moveFirst();
        dt.getBtnFirst().addActionListener((e) -> {
            //get the current row
            int currentIndex = dt.dataTable.getSelectedRow();
            //if current row was the first row, show message
            if (currentIndex == 0) {
                JOptionPane.showMessageDialog(null, "This row was the first row");
            }
            moveFirst();
        });

        dt.getBtnLast().addActionListener((e) -> {
            //get the current row
            int currentIndex = dt.dataTable.getSelectedRow();
            //if current row was the first row, show message
            if (currentIndex == 0) {
                JOptionPane.showMessageDialog(null, "This row was the last row");
            }
            moveLast();
        });

        dt.getBtnNext().addActionListener((e) -> {

            moveNext();

        });

        dt.getBtnPrevious().addActionListener((e) -> {

            movePrevious();

        });
    }
}
