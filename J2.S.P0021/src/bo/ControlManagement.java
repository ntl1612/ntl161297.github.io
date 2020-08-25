/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import gui.AddCourse;
import gui.CourseManagement;
import gui.ListCourse;
import gui.SearchCourse;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JFrame;
//import java.util.Collections;


public class ControlManagement {

    private final CourseManagement courseManagement;
    private ArrayList<Course> arr = new ArrayList<>();
    private SearchCourse searchCourse = new SearchCourse();
    private ListCourse listCourse = new ListCourse();
    private AddCourse addCourse = new AddCourse();
    
    public ControlManagement(CourseManagement courseManagement) {
        this.courseManagement = courseManagement;
       courseManagement.setVisible(true);
        courseManagement.setTitle("Course Management");
        courseManagement.setResizable(false);
        courseManagement.setLocationRelativeTo(null);
    }

    public void add() {
        addCourse.setArr(arr);
        addCourse.clear();
        addCourse.setVisible(true);
        addCourse.setLocationRelativeTo(null);
        addCourse.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void display() {
        listCourse.setVisible(true);
        displayList(arr);
        listCourse.setLocationRelativeTo(null);
        listCourse.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void search() {
        searchCourse.setArray(arr);
        searchCourse.reset();
        searchCourse.setVisible(true);
        searchCourse.setLocationRelativeTo(null);
        searchCourse.setResizable(false);
        searchCourse.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    public void displayList(ArrayList<Course> array) {
        listCourse.txt.setText("");
        listCourse.setResizable(false);
        Collections.sort(array);
        for (Course course : array) {
            listCourse.txt.setText(listCourse.txt.getText() + course.toString() + "\n");
        }
    }
    public void exit() {
        System.exit(0);
    }
}
