package LabOne;

import javax.swing.JOptionPane;

public class PolyndromTrueFalse {

    public static void main(String args[]){
    
        String number;
        int too,negj, zuut;
        
        number = JOptionPane.showInputDialog("3 оронтой тоо оруулна уу");
        too = Integer.parseInt(number);
        zuut = too/100;
        negj = too%10;
        if(zuut==negj){
            JOptionPane.showMessageDialog(null, "This is polyndrom");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(null, "This is not polyndrom");
            System.exit(0);
        }
    }
}
