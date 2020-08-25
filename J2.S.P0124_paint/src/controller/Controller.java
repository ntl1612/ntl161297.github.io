/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.MainFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author pc
 */
public class Controller {
    private MainFrame main;
    private Graphics g;
    private Point a, b;
    private Color c;
    public Controller(MainFrame main) {
        this.main = main;
    }
    
    // draw line
    public void draw() {

        g = main.panel.getGraphics();
        g.setColor(c);
        g.drawLine(a.x, a.y, b.x, b.y); //được sử dụng để vẽ line giữa hai điểm có tọa độ lần lượt là (x1, y1) và (x2, y2).
        a = b;
    }
    // get value point a and b
    // sự kiện xử lí con chuột
    public void pressedMouse(java.awt.event.MouseEvent evt){ // được gọi khi một nút chuột được nhấn và nhả trên component mà không di chuyển chuột
        
        a = evt.getPoint(); // lấy tọa độ điểm 1
        b = evt.getPoint(); // lấy tọa độ điểm 2
        draw();
    }
    //get value when drag mouse 
    public void draggedMouse(java.awt.event.MouseEvent evt){//được gọi khi người dùng nhấn một nút chuột và kéo trên một component
        b = evt.getPoint();
        draw();
    }
   
    public void clear(){//vẽ lại
        main.repaint();
    }
    
    JButton oldColor = null;
    
    public void getColor(java.awt.event.ActionEvent evt){
        
        JButton color = (JButton) evt.getSource();
        if (oldColor != null) 
            {
                oldColor.setBorder(BorderFactory.createEmptyBorder());// remove boder old color
            }
            
        color.setBorder(BorderFactory.createLineBorder(Color.white,2));// tạo màu đường bao 
        c = color.getBackground();
        
        oldColor = color;
    }

   
}
