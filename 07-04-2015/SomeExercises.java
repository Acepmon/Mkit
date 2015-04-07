package javatest;

/**
 *
 * @author Acep / D.Tsogtbayar
 */
public class SomeExercises {
    
    private java.util.Scanner in = new java.util.Scanner(System.in);
    
    /*
        Эхний N ширхэг тоог хэвлэ
    */
    private void Ex1() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a=1;a<=n;a++) {
            System.out.println(a);
        }
    }
    
    /*
        Эхний N ширхэг сондгой тоог хэвлэ
    */
    private void Ex2() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a=1;a<=n;a++) {
            if (n % 2 == 1) {
                System.out.println(a);
            }
        }
    }
    
    /*
        Эхний N ширхэг тэгш тоонуудыг хэвлэ
    */
    private void Ex3() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a=0;a<n;a++) {
            if (n % 2 == 0) {
                System.out.println(a);
            }
        }
    } 
    
    /*
        Өгөгдсөн тооны бүх хуваагчдыг хэвлэ
    */
    private void Ex4() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a = 1; a <= n; a++) {
            
        }
    }
    
    /*
        1000 дотор байгаа бүх анхны тоонуудыг хэвлэ
    */
    private void Ex5() {
        int limit = 1000;
        Boolean isPrime = false;
        for (int a=1; a<=limit; a++) {
            int p = 0;
            isPrime = true;
            for (int x =2; x <= a/2; x++) {
                if (a % x == 0)  {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(a);
                break;
            }
        }
    }
    
    /*
        Эхний N ширхэг төгс тоонуудыг хэвлэ.
        (хуваагчдынхаа нийлбэртэй тэнцүү тоог төгс тоо гэнэ. Жш: 6 = 1 + 2 + 3 тул 6 төгс тоо мөн)
    */
    private void Ex6() {
        
    }
    
    public SomeExercises() {
        int choose;
        do {
            System.out.println("\t0. Exit");
            System.out.println("\t1. Exercise 1");
            System.out.println("\t2. Exercise 2");
            System.out.println("\t3. Exercise 3");
            System.out.println("\t4. Exercise 4");
            System.out.println("\t5. Exercise 5");
            System.out.println("\t6. Exercise 6");
            
            System.out.print(": ");
            choose = in.nextInt();
            
            switch (choose) {
                case 1:
                    Ex1();
                    break;
                case 2:
                    Ex2();
                    break;
                case 3:
                    Ex3();
                    break;
                case 4:
                    Ex4();
                    break;
                case 5:
                    Ex5();
                    break;
                case 6:
                    Ex6();
                    break;
            }
        } while (choose != 0);
    }
}
