
package com.java.myapp;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Dialog {
     public static void setLAF() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.err.println("Failed to set LookAndFeel");

        }
    }
    static void FileError(String name) {
        JOptionPane.showMessageDialog(null,
                "File "+ name +"\nError !!!",
                "Error!",
                JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
     
}
