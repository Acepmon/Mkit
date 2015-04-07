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
//        int i = 1;
//        Boolean isPrime = false;
//        do {
//            i++;
//            isPrime = true;
//            for (int x =2; x <= i/2; x++) {
//                if (i % x == 0)  {
//                    isPrime = false;
//                }
//                if (isPrime) {
//                    System.out.println(i);
//                    break;
//                }
//            }
//        } while (i <= 1000);
        
        for (int a = 2; a <= 1000; a++) {
            int t;
            t = a / 2;
            if (a % t == 1) {
                System.out.println(a);
            }
        }
    }
    
    /*
        Эхний N ширхэг төгс тоонуудыг хэвлэ.
        (хуваагчдынхаа нийлбэртэй тэнцүү тоог төгс тоо гэнэ. Жш: 6 = 1 + 2 + 3 тул 6 төгс тоо мөн)
    */
    private void Ex6() {
        
    }
    
    /*
        Өгсөн тооны 2-тын бичлэгийг хэвлэ
    */
    private String getRem(int num) {
        int div = num / 2;
        int rem = num % 2;
        if (rem == 1 || rem == 0) {
            
        }
        return ""+rem;
    }
    private void Ex7() {
        System.out.print("N: ");
        int n = in.nextInt();
        getRem(n);
        System.out.println();
    }
    
    /*
        2-тын бичлэгээр өгөгдсөн тоог 10-тын
        тооллын системд шилжүүл
    */
    private void Ex8() {
        
    }
    
    /*
        Өгөгдсөн тооны бүх цифрүүдийг үсэглэн хэвлэдэг програм бич.
        Жишээ нь 154 гэж оруулахад: neg tav dorov гэж хэвлэнэ.
    */
    private void Ex9() {
        
    }
    
    /*
        Хэрэглэгч төрсөн сар, өдрөө өгөнгүүт ямар ордонд төрснийг хэвлэдэг програм бич.
    */
    private void Ex10() {
        
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
            System.out.println("\t7. Exercise 7");
            System.out.println("\t8. Exercise 8");
            System.out.println("\t9. Exercise 9");
            System.out.println("\t10. Exercise 10");
            
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
                case 7:
                    Ex7();
                    break;
                case 8:
                    Ex8();
                    break;
                case 9:
                    Ex9();
                    break;
                case 10:
                    Ex10();
                    break;
            }
        } while (choose != 0);
    }
    public static void main(String[] args) {
        new SomeExercises();
    }
}
