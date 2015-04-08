
package javatest;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class SumOfNumbers {
    
    public SumOfNumbers(java.util.Scanner in) {
        int total = 0;
        for (int a = 2; a <= 100; a++) {
            if ((a % 2) == 0) total += a;
        }
        System.out.println("Total number is : " + total);
    }
    
}
