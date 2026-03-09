package com.project1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String midterm1Grade = JOptionPane.showInputDialog("Enter your grade for mid 1: ");
        int mid1 = Integer.parseInt(midterm1Grade);
        String midterm2Grade = JOptionPane.showInputDialog("Enter grade for mid 2: ");
        int mid2 = Integer.parseInt(midterm2Grade);
        String finalGrade = JOptionPane.showInputDialog("Enter final grade: ");
        int fin = Integer.parseInt(finalGrade);

        double total = fin*0.6 + ((mid1 + mid2)/2)*0.4;
        JOptionPane.showMessageDialog(null, "Your midterm1 grade is: " + mid1 + "\n" +
                                                                    "Your midterm2 grade is: " + mid2 + "\n" +
                                                                    "Your final grade is: " + fin + "\n" +
                                                                    "Your semester grade is: " + total + "\n");
        System.exit(0);
    }
}
