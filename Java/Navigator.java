package javatest;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class Navigator {
    
    private static void InitArray() {
        int array[];
        array = new int[10];
        String output = "Дугаар\tУтга\n";
        for (int counter=0; counter<array.length; counter++) {
            output += counter + "\t"+array[counter]+"\n";
        }
        JTextArea outputArea = new JTextArea();
        outputArea.setText(output);
        outputArea.setEditable(false);
        JOptionPane.showMessageDialog(null, outputArea, "Initializing an Array of int Values", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    private static void DoubleArray() {
        double array[];
        array = new double[10];
        String output = "Дугаар\tУтга\n";
        for (int counter=0; counter<array.length; counter++) {
            output += counter + "\t"+array[counter]+"\n";
        }
        JTextArea outputArea = new JTextArea();
        outputArea.setText(output);
        outputArea.setEditable(false);
        JOptionPane.showMessageDialog(null, outputArea, "Initializing an Array of int Values", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choose;
        do {
            System.out.println("0. Exit");
            System.out.println("1. Average Number");
            System.out.println("2. Something");
            System.out.println("3. Sum of numbers");
            System.out.println("4. Prime Numbers");
            System.out.println("5. Init Array");
            System.out.println("6. Double Array");
            System.out.println("7. Some Exercises");
            System.out.print(": ");
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    Average avg = new Average(in);
                    break;
                case 2:
                    Something some = new Something(in);
                    break;
                case 3:
                    SumOfNumbers sum = new SumOfNumbers(in);
                    break;
                case 4:
                    PrimeNumbers prime = new PrimeNumbers(in);
                    break;
                case 5:
                    InitArray();
                    break;
                case 6:
                    DoubleArray();
                    break;
                case 7:
                    SomeExercises someEx = new SomeExercises();
                    break;
            }
        } while (choose != 0);
    }
    
}
