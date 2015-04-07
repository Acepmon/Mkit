package javatest;

/**
 *
 * @author User M 2
 */
public class Something {

    public Something(java.util.Scanner in) {
        double total = 0;
        int counter = 1;
        int start, end;
        
        System.out.println("Set start and end length!");
        System.out.print(": ");
        for (start = in.nextInt(), end = in.nextInt(); start <= end; start++) {
            
        }
        System.out.println("Average is "+(double)(total / counter));
    }
}
