package main;

import controller.Controller;
import view.DataTable;

/**
 *
 * @author Thanh Long Nguyen
 */
public class Main {

    public static void main(String[] args) {
        Controller c = new Controller(new DataTable());
        c.action();
    }
}
