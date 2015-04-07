package javatest;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class PrimeNumbers {
    public PrimeNumbers(java.util.Scanner in) {
        int i = 1;
        Boolean isPrime = false;
        do {
            i++;
            isPrime = true;
            for (int x =2; x <= i/2; x++) {
                if (i % x == 0)  {
                    isPrime = false;
                }
                if (isPrime) {
                    System.out.println(i);
                    break;
                }
            }
        } while (i <= 1000);
    }
}
