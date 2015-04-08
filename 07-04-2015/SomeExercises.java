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
    
    /*
        Тайлбар хэрэггүй байлгүйдээ
    */
    private void Ex1() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a = 1; a <= n; a++) {
            System.out.println(a);
        }
    }

    /*
     Эхний N ширхэг сондгой тоог хэвлэ
     */
    
    /*
        Тайлбар хэрэггүй байлгүйдээ
    */
    private void Ex2() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a = 1; a <= n; a++) {
            if (n % 2 == 1) {
                System.out.println(a);
            }
        }
    }

    /*
     Эхний N ширхэг тэгш тоонуудыг хэвлэ
     */
    
    /*
        Тайлбар хэрэггүй байлгүйдээ
    */
    private void Ex3() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a = 0; a < n; a++) {
            if (n % 2 == 0) {
                System.out.println(a);
            }
        }
    }

    /*
     Өгөгдсөн тооны бүх хуваагчдыг хэвлэ
     */
    
    /*
        Тайлбар хэрэггүй байлгүйдээ
    */
    private void Ex4() {
        System.out.print("N: ");
        int n = in.nextInt();
        for (int a = 1; a <= n; a++) {
            if (n % a == 0) {
                System.out.println(a);
            }
        }
    }

    /*
     1000 дотор байгаа бүх анхны тоонуудыг хэвлэ
     */
    
    // Анхны тоо эсхийг шалгах функц
    private boolean isPrime(int n) {
        // 1 ын тоо анхны тоонд ордгүй учир хасаж өгөх
        if (n == 1) {
            return false;
        }
        // n тоо 2 ын хуваагдал уу гэдгийг шалгах
        if (n % 2 == 0) {
            return false;
        }
        // биш байхын бол сондгой тоогын шалгах
        for (int a = 3; a * a <= n; a += 2) {
            if (n % a == 0) {
                return false;
            }
        }
        return true;
    }

    private void Ex5() {
        for (int a = 1; a <= 1000; a++) {
            if (isPrime(a)) {
                System.out.println(a);
            }
        }
    }

    /*
     Эхний N ширхэг төгс тоонуудыг хэвлэ.
     (хуваагчдынхаа нийлбэртэй тэнцүү тоог төгс тоо гэнэ. Жш: 6 = 1 + 2 + 3 тул 6 төгс тоо мөн)
     */
    private boolean isPerfect(int b) {
        // Үлдэгдэл 0-тэй тэнцүү тоонуудыг 'c' хувьсагчид нэмэх
        int c = 0;
        // Өгөгдсөн тооны 1/2 хүртэл давталд явагдана
        for (int a = 1; a <= b / 2; a++) {
            /* 
                Хэрвээ 'a' хувьсагч анхны өгөгдсөн 'b' хуваагдлын үлдэгдэл 
                0 тай тэнцүү байваас зөв хуваагч гэж авна. 
            */
            if (b % a == 0) {
                // Зөв хуваагч тоог олсноор харьцуулалт хийгдэх 'c' хувьсагчид нэмж өгнө.
                c+=a;
            }
        }
        // Хэрвээ 'c' 'b'-тай тэнцүү байваас үнэн 'true' буцаагдаж худлаа байваас 'false' утга буцна.
        return c == b;
    }
    private void Ex6() {
        System.out.print("N тоо оруулна уу: ");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (isPerfect(i)) {
                System.out.println(""+i);
            }
        }
    }

    /*
     Өгсөн тооны 2-тын бичлэгийг хэвлэ
     */
    /* 
        2-тын тооллын системд хөрвүүлэхэд recursive 
        функц ашигласан байгаа. 'n' хувьсагчид байнгын 10-тын
        тоонууд орж байгаа.
    
        Гэхдээ гар аргаар функц бичихгүйгээр хөрвүүлэх арга
        бол Integer.toBinaryString() гэсэн Java функц ашиглаж болно.
    */
    private void printBin(int n) {
        // 'r' хувьсагч 'n' утгын 2-т хуваасны үлдэгдэл хадгалах үүрэгтэй
        int r;
        // Хэрвээ 'n' утганд 1 эсвэл 0 утга орж ирвэл
        if (n <= 1) {
            // 'n' утгыг шууд хэвлэх
            System.out.print(n);
            // Recursive давталтыг дуусгах ба цааш нь давтах нөхцөл байхгүй
            return;
        }
        // 'n' 2-т хуваагдсны үлдэгдэл 'r' хувьсагчид оноогдоно.
        r = n % 2;
        /*
            Өөрийгөө дахин дуудаж байгаа ба параметер утга нь 'n'-дэх утгыг
            баруун 1 удаа түлхсэн утгыг дамжуулж байна.
        
            Дэлгэрэнгүй тайлбар:
                'n'-ийн утга 28 гэж үзий.
                28 гэсэн тоо 2-тын тооллолд 11100 юм.
                '>>' энэ оператор 28 гэсэн тоог илэрхийлж буй 2-тын тоог
                баруун түлхдэг юм.
                11100 энийг баруун 1 түлхий гэхийн бол 01110 гэсэн хэлбэрт орно.
                01110-н 10-тын системд 14 гэсэн тоо ба 28 ны 2 хувуугдсан тоо юм.
                
                Энгэж бичихгүйгээр 'n / 2' гэж дамжуулж болно.
                Энэхүү функцэд 'n >> 1' энэ бичлэгийг авсан юм.
        */
        printBin(n >> 1);
        // Recursive давталт дууссаны дараа хэвлэгдэх ба энэ нь оригнал 'n' тооны үлдэгдэл
        System.out.print(r);
    }
    private void Ex7() {
        System.out.print("N: ");
        int n = in.nextInt();
        System.out.print("Binary numbers are : ");
        printBin(n);
        System.out.println("");
    }

    /*
     2-тын бичлэгээр өгөгдсөн тоог 10-тын
     тооллын системд шилжүүл
     */
    private void Ex8() {
        System.out.print("Type binary numbers: ");
        // 10-т болгон хувиргах авах 2-тын тоонууд оролтоор авах
        String n = in.next();
        // Хувиргалт хийгдсэн 10-тын тоог хадгалах хувьсагч
        double bin = 0;
        // 'n' string-ын урт хүртэл явах давталт
        for (int a = 0; a < n.length(); a++) {
            // 'n' string-ыг тэмдэгтээр нь '1' гэсэн тэмдэгтэй харьцуулна
            if (n.charAt(a) == '1') {
                // 'bin' хувьсагчид 2 тоог зэрэгт дэвшүүлсэн утгыг нэмж өгөх.
                bin = bin + Math.pow(2, n.length()-1-a);
            }
        }
        // Хувиргалт хийгдсэны дараа 10-тын тоог хадгалсан 'bin' хувьсагчыг хэвлэх
        System.out.println("Decimal numbers are : "+bin);
    }

    /*
     Өгөгдсөн тооны бүх цифрүүдийг үсэглэн хэвлэдэг програм бич.
     Жишээ нь 154 гэж оруулахад: neg tav dorov гэж хэвлэнэ.
     */
    
    /*
        Энэхүү функцэд тоо дамжуулваас тэрхүү тоог үсэг хэлбэрээр буцаана.
    */
    private String getToo(int n) {
        switch (n) {
            case 0: return "тэг";
            case 1: return "нэг";
            case 2: return "хоёр";
            case 3: return "гурав";
            case 4: return "дөрөв";
            case 5: return "тав";
            case 6: return "зургаа";
            case 7: return "долоо";
            case 8: return "найм";
            case 9: return "ес";
            case 10: return "арав";
            default: return "";
        }
    }
    private void Ex9() {
        System.out.print("Type numbers: ");
        String n = in.next();
        for (int a = 0; a < n.length(); a++) {
            int num = Character.getNumericValue(n.charAt(a));
            System.out.print(getToo(num) + " ");
        }
        System.out.println("");
    }

    /*
     Хэрэглэгч төрсөн сар, өдрөө өгөнгүүт ямар ордонд төрснийг хэвлэдэг програм бич.
     */
    
    private void Ex10() {
        System.out.print("Төрсөн сар : ");
        String month = in.next();
        System.out.print("Төрсөн өдөр: ");
        String day = in.next();
        
        /*
            Сар өдрийг нийлүүлж жишиж болох тоонд хувиргаж
            тэрхүү тооноос ордны заалтанд дотор байгааг
            шалгах.
        
            Хэрвээ 8-сарын 21-нд төрсөн гэж оруулвал
            'a' хувьсагчид 8.21 гэсэн утга орж ирнэ.
        */
        float a = Float.valueOf(""+month+"."+day);
        /* 
            Ордуудын сар өдрийн заалтыг оруулж өгсөн байгаа
            'a > 1.21 & a < 2.18' гэдэг нь 'a' хувьсагч 1.21 гэсэн утгаас 
            илүү байнуу гэдгийг шалгаж бас 2.18 гэсэн утгаас бага байнуу
            гэдгийг шалгасан. Хэрвээ 2 нөхцөл үнэн байваас тэрхүү ордыг хэвлэнэ.
        */
        if (a > 1.21 & a < 2.18) {
            System.out.println("Хумх");
        } else if (a > 2.19 & a < 3.20) {
            System.out.println("Загас");
        } else if (a > 3.21 & a < 4.20) {
            System.out.println("Хонь");
        } else if (a > 4.21 & a < 5.21) {
            System.out.println("Үхэр");
        } else if (a > 5.22 & a < 6.21) {
            System.out.println("Ихэр");
        } else if (a > 6.22 & a < 7.22) {
            System.out.println("Мэлхий");
        } else if (a > 7.23 & a < 8.23) {
            System.out.println("Арслан");
        } else if (a > 8.24 & a < 9.23) {
            System.out.println("Охин");
        } else if (a > 9.24 & a < 10.23) {
            System.out.println("Жинлүүр");
        } else if (a > 10.24 & a < 11.22) {
            System.out.println("Хилэнц");
        } else if (a > 11.23 & a < 12.21) {
            System.out.println("Нум");
        } else if (a > 12.22 & a < 1.20) {
            System.out.println("Матар");
        }
    }

    public SomeExercises() {
        int choose;
        do {
            System.out.println("\t0. Exit");
            System.out.println("\t1. Exercise 1 N ширхэг тоог хэвлэх");
            System.out.println("\t2. Exercise 2 N ширхэг сондгой тоонуудыг хэвлэх");
            System.out.println("\t3. Exercise 3 N ширхэг тэгш тоонуудыг хэвлэх");
            System.out.println("\t4. Exercise 4 Өгөгдсөн тооны бүх хуваагчдыг хэвлэх");
            System.out.println("\t5. Exercise 5 1000 доторх анхны тоог олох");
            System.out.println("\t6. Exercise 6 Төгс тоог олох");
            System.out.println("\t7. Exercise 7 Тоог 2-т луу шилжүүлэх");
            System.out.println("\t8. Exercise 8 2-тыг 10-т луу шилжүүлэх");
            System.out.println("\t9. Exercise 9 Тоог үсэг хэлбэрээр авах");
            System.out.println("\t10. Exercise 10 Төрсөн сар өдрөөс орд олох");

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
