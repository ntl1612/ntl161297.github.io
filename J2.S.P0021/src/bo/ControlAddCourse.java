/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import gui.AddCourse;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ControlAddCourse {

    private AddCourse addCourse;
    private ArrayList<Course> arr;
    private String name;
    private int credit;
        

    public boolean checknull(){
        if(addCourse.txtCode.getText().trim().length()<= 0){
            JOptionPane.showMessageDialog(addCourse, "Code is null");
            addCourse.txtCode.requestFocus();
            return false;
        } else if(addCourse.txtName.getText().trim().length()<= 0){
            JOptionPane.showMessageDialog(addCourse, "Name is null");
            addCourse.txtName.requestFocus();
            return false;
        }else if (addCourse.txtCredit.getText().trim().length() <= 0){
            JOptionPane.showMessageDialog(addCourse, "Credit is null");
            addCourse.txtCredit.requestFocus();
            return false;
        }
        return true;
    }
     private String normalName(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i + 1)));
            }
        }
        return sb.toString();
    }
        public boolean validate() {
        try {
            credit = Integer.parseInt(addCourse.getCredit());
            if (credit <= 0 || credit > 33) {
                JOptionPane.showMessageDialog(addCourse, "Credit must be >0 and <33");
                return false;
            }
            name = addCourse.getName();
            name = normalName(name);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(addCourse, "Credit must be number");
            return false;
        }
        return true;
        
    }
        public boolean validatename(){
            if (!(Pattern.matches("[a-zA-Z0-9 ]+", addCourse.txtName.getText()))) {
                JOptionPane.showMessageDialog(null, "Name must be string", "Error", JOptionPane.ERROR_MESSAGE);
                    addCourse.txtName.setFocusable(true);
                   return false;
                 }
            return true;
        }
    public ControlAddCourse(AddCourse addCourse) {
        this.addCourse = addCourse;
        addCourse.setTitle("Add Course");
        addCourse.setResizable(false);
    }

    public void setArr(ArrayList<Course> arr) {
        this.arr = arr;
    }

    public void clear() {
        if(addCourse.txtCode.getText().trim().length()<= 0 &&
                addCourse.txtName.getText().trim().length()<= 0 &&
                        addCourse.txtCredit.getText().trim().length() <= 0
                        ){
            JOptionPane.showMessageDialog(addCourse, "Nothing to clear!");
        }
        addCourse.clear();
    }

    public void add() {
        if (checknull() && validatename() && validate()) {
            for (Course course : arr) {
                if (course.getCode().equalsIgnoreCase(addCourse.getCode())) {
                    JOptionPane.showMessageDialog(addCourse, "Duplicate code");
                    return;
                }
            }
            JOptionPane.showMessageDialog(addCourse, "Add Successful");
            Course course = new Course(addCourse.getCode(), name, Integer.parseInt(addCourse.getCredit()));
            arr.add(course);          
            addCourse.setVisible(true);
        }

    }
}
