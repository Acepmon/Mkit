/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import javax.swing.JOptionPane;

/**
 *
 * @author JAVA M2
 */
public class PT {

    private char[] whitelist = {'+','-','*','/','%','^','0','1','2','3','4','5','6','7','8','9'};
    private char[] operators = {'+','-','*','/','%','^'};
    private char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
    
    public PT(String in) {
        String out = null;
        char[] out_ch = null;
        in = clean(in);
        out_ch = save(in);
        out_ch = fix(out_ch);
        for (char c : out_ch) {
            System.out.print(c);
        }
    }
    private String clean(String in) {
        String out = null;
        out = in.replaceAll("\\s+", "");
        out = in.replaceAll("\\(|\\)", "");
        return out;
    }
    private char[] save(String in) {
        CharList list = new CharList();
        for (char c : in.toCharArray()) {
            for (char w : whitelist) {
                if (c == w) {
                    list.add(c);
                }
            }
        }
        return list.getArray();
    }
    private char[] fix(char[] in) {
        CharList list = new CharList();
        
        boolean addOper = false;
        boolean addNum = false;
        
        char a = ' ',b = ' ',d = ' ';
        int j = 0;
        
        for (char c : in) {
            for (char o : operators) {
                if (c == o) {
                    if (j == 0) {
                        a = c;
                        b = c;
                        d = b;
                        break;
                    } else {
                        b = c;
                        a = d;
                        j++;
                        
                        if (j < 2) {
                            addOper = true;
                            break;
                        }
                    }
                } else {
                    addOper = false;
                }
            }
            for (char n : numbers) {
                if (c == n) {
                    addNum = true;
                    j = 0;
                    break;
                } else {
                    addNum = false;
                }
            }
            if (addOper | addNum) {
                list.add(c);
            }
        }
        
        return list.getArray();
    }
    
    public static void main(String[] args) {
        new PT(JOptionPane.showInputDialog("Expression!"));
    }
}
