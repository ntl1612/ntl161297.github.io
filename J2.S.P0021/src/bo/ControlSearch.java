/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import gui.SearchCourse;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlSearch {

    private SearchCourse searchCourse;
    private ArrayList<Course> arr;

    public ControlSearch(SearchCourse sc) {
        searchCourse = sc;
        sc.setTitle("Search Course");
    }

    public void show() {
        searchCourse.setVisible(true);
    }

    public void setArr(ArrayList<Course> arr) {
        this.arr = arr;
    }

    public void clear() {
        searchCourse.setTxtCode("");
        searchCourse.setTxtName("");
        searchCourse.setTxtCredit("");
    }

    public boolean checknull() {
        if (searchCourse.txtCode.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(searchCourse, "Code null");
            searchCourse.txtCode.requestFocus();
            return false;
        }
        return true;
    }

    public void search(String code) {
        if (checknull()) {
            for (Course course : arr) {
                if (course.getCode().equalsIgnoreCase(code)) {
                    searchCourse.setTxtName(course.getName());
                    searchCourse.setTxtCredit("" + course.getCredit());
                    return;
                }
            }
            searchCourse.setTxtName("Not Found");
            searchCourse.setTxtCredit("Not Found");
        }
    }
}
