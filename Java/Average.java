
package javatest;

import java.util.Scanner;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class Average {
    public Average(Scanner in) {
        double total = 0;
        int counter = 1;
        int start, end;
        
        System.out.println("Set start and end length!");
        System.out.print(": ");
        for (start = in.nextInt(), end = in.nextInt(); start <= end; start++) {
            System.out.print("Grade "+start+" : ");
            double tmp = in.nextDouble();
            total += tmp;
            counter++;
        }
        System.out.println("Average is "+(double)(total / counter));
    }
}
