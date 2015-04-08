package javatest;

import com.sun.javafx.PlatformUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class CalculatorConsole {

    private Scanner in = new Scanner(System.in);
    
    public CalculatorConsole() {
        double a = 0, b = 0;
        int choose = 0;
        do {
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Remainder");
            
            System.out.println("10. Custom");
            
            System.out.println("\n0. Exit");
            
            System.out.print(": ");
            
            try {
                choose = in.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("Input wrong!");
                choose = 0;
            }
            
            switch (choose) {
                case 1: 
                    System.out.print("Enter 1st number: ");
                    a = in.nextDouble();
                    System.out.print("Enter 2nd number: ");
                    b = in.nextDouble();
                    System.out.println("Result: "+Addition(a, b));
                    break;
                case 2: 
                    System.out.print("Enter 1st number: ");
                    a = in.nextDouble();
                    System.out.print("Enter 2nd number: ");
                    b = in.nextDouble();
                    System.out.println("Result: "+Substraction(a, b));
                    break;
                case 3: 
                    System.out.print("Enter 1st number: ");
                    a = in.nextDouble();
                    System.out.print("Enter 2nd number: ");
                    b = in.nextDouble();
                    System.out.println("Result: "+Multiplication(a, b));
                    break;
                case 4: 
                    System.out.print("Enter 1st number: ");
                    a = in.nextDouble();
                    System.out.print("Enter 2nd number: ");
                    b = in.nextDouble();
                    System.out.println("Result: "+Division(a, b));
                    break;
                case 5: 
                    System.out.print("Enter 1st number: ");
                    a = in.nextDouble();
                    System.out.print("Enter power number: ");
                    b = in.nextDouble();
                    System.out.println("Result: "+Power(a, b));
                    break;
                case 6: 
                    System.out.print("Enter number to square rooted by: ");
                    a = in.nextDouble();
                    System.out.println("Result: "+Square(a));
                    break;
                case 7:
                    System.out.print("Enter 1st number: ");
                    a = in.nextDouble();
                    System.out.print("Enter 2nd number: ");
                    b = in.nextDouble();
                    System.out.println("Result: "+Remainder(a, b));
                    System.out.println("Diviser: "+Division(a, b));
                    break;
                case 10:
                    String custom = JOptionPane.showInputDialog("Type custom algebra");
                    Custom(custom);
                    break;
                default:
                    break;
            }
            System.out.println("");
        } while (choose != 0);
    }
    private double Addition(double a, double b) {
        return a + b;
    }
    private double Substraction(double a, double b) {
        return a - b;
    }
    private double Multiplication(double a, double b) {
        return a * b;
    }
    private double Division(double a, double b) {
        return a / b;
    }
    private double Power(double a, double b) {
        return Math.pow(a, b);
    }
    private double Square(double a) {
        return Math.sqrt(a);
    }
    private double Remainder(double a, double b) {
        if (a >= b) {
            return a % b;
        } else {
            return b % a;
        }
    }
    private void Custom(String custom) {        
        custom = removeSpace(custom);
        getResult(custom);
    }
    private void getResult(String input) {
        char[] ch_in = new char[input.length()+2];
        for (int a = 0, b = 0; a < ch_in.length | b < input.length(); a++) {
            if (a == 0) {
                ch_in[a] = '(';
            } else if (a == ch_in.length-1) {
                ch_in[a] = ')';
            } else {
                ch_in[a] = input.charAt(b);
                b++;
            }
        }
        
    }
    private ArrayList<Object> rec(ArrayList<Object> input) {
        ArrayList<Object> inner;
        ArrayList<Object> rec_out;
        ArrayList<Double> computed;
        ArrayList<Object> computed_obj;
        
        inner = inBrack(input);
        if (inner != null) {
            rec_out = rec(inner);
            input = rep(input, inner, rec_out);
        }
        
        computed = compute(input);
        computed_obj = convDouble(computed);
        return computed_obj;
    }
    private ArrayList<Object> inBrack(ArrayList<Object> input) {
        return null;
    }
    private ArrayList<Object> rep(ArrayList<Object> current, ArrayList<Object> target, ArrayList<Object> replacement) {
        return null;
    }
    private ArrayList<Double> compute(ArrayList<Object> input) {
        ArrayList<Double> computed = new ArrayList<>();
        
        double[] nums;
        
        String operator = "";
        String statement;
        
        
        Pattern oper = Pattern.compile("[0-9]{1,}([\\W]{1})[0-9]{1,}");
        Matcher mat;
        // FIX THIS HORSESHIT CODE !!!!
        for (Object obj : input) {
            statement = obj.toString();
            statement = statement.replaceAll("\\(|\\)", "");
            mat = oper.matcher(statement);
            if (mat.find())
                operator = mat.group();
            String[] state = statement.split("\\"+operator);
            // Get individual numbers from statement
        }
        
        return computed;
    }
    private ArrayList<Object> convDouble(ArrayList<Double> doubles) {
        ArrayList<Object> convertedDubs = new ArrayList<>();
        for (Double d : doubles) {
            convertedDubs.add(String.valueOf(d));
        }
        return convertedDubs;
    }
    
    private String removeSpace(String input) {
        return input.replaceAll("\\s+", "");
    }
    private ArrayList matchFinder(String input, String regex) {
        ArrayList<String> output = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        while (match.find()) {
            output.add(match.group());
        }
        return output;
    }
    
    public static void main(String[] args) {
        CalculatorConsole cc = new CalculatorConsole();
    }
}