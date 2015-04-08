package LabOne;

import javax.swing.JOptionPane;

public class Addition {

    public static void main(String args[]){
    
        String firstNumber;
        String secondNumber;
        int first, second, sum;
        
        firstNumber = JOptionPane.showInputDialog("Эхний тоо");
        secondNumber = JOptionPane.showInputDialog("Хоёр дахь тоо");
        
        first = Integer.parseInt(firstNumber);
        second = Integer.parseInt(secondNumber);
        sum = first+second;
        JOptionPane.showMessageDialog(null, "Нийлбэр = "+sum,
                "Үр дүн",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
