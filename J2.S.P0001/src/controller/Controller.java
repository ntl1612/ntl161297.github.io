/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import view.Display;

/**
 *
 * @author Admins
 */
public class Controller {
    private final Display display;
    private final ImageIcon icon1 = new ImageIcon("Images/1.jpg");
    private final ImageIcon icon2 = new ImageIcon("Images/2.jpg");
    private final ImageIcon icon3 = new ImageIcon("Images/3.jpg");
    private final ImageIcon icon4 = new ImageIcon("Images/4.jpg");
    private final ImageIcon icon5 = new ImageIcon("Images/5.jpg");

    public Controller(Display display) {
        this.display = display;
    }
    
    private void setImagesforButton(JButton button, ImageIcon icon) {

        Image image = icon.getImage().getScaledInstance(button.getWidth() - 10,
                button.getHeight() - 10, java.awt.Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(image));
    }
    
    private void setImagesforLabel(JLabel label, ImageIcon icon) {
        /*
            This fuction set a image for a label.
         */
        Image image = icon.getImage().getScaledInstance(label.getWidth(),
                label.getHeight(), java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    public void ButtonImage() {
        setImagesforButton(display.getBtn1(), icon1);
        setImagesforButton(display.getBtn2(), icon2);
        setImagesforButton(display.getBtn3(), icon3);
        setImagesforButton(display.getBtn4(), icon4);
        setImagesforButton(display.getBtn5(), icon5);
    }
    
    public void Display(){
        display.getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setImagesforLabel(display.getLblDisplay(), icon1);
            }
        });
        display.getBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setImagesforLabel(display.getLblDisplay(), icon2);
            }
        });
        display.getBtn3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setImagesforLabel(display.getLblDisplay(), icon3);
            }
        });
        display.getBtn4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setImagesforLabel(display.getLblDisplay(), icon4);
            }
        });
        display.getBtn5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setImagesforLabel(display.getLblDisplay(), icon5);
            }
        });
    }
}
