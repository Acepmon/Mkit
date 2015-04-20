package LabLesson2;

import java.util.StringTokenizer;


public class JavaSyntax5 {
    public static void main(String[] args){
        //Advenced Java Syntax
        String course = "Java Foundations";
        String Scourse = course.substring(5);
        System.out.println(Scourse);

        Scourse = course.substring(5, 11);
        System.out.println(Scourse);

        System.out.println("Advenced Java Syntax");
        System.out.println("**************************");

        //StringBuffer
            StringBuffer sb1 = new StringBuffer("My StringBuffer1");
            StringBuffer sb2 = null;
            sb2 = new StringBuffer("My StringBuffer2");
            System.out.println(sb1);
            System.out.println(sb2);

        //Length   уртыг нь олдог функц
            int length = sb1.length();
            System.out.println(length);

        //capacity
        StringBuffer sbb1 = new StringBuffer();
        StringBuffer sbb2 = new StringBuffer(16);

        //append
        sbb2.append("Foundations");
        System.out.println(sbb2);

        //equals() and compareTo()
        String s1 = "Java";
        String s2 = "Foundations";
        String s3 = "JavaFoundations";

        System.out.println("s1 = "+s1);
        System.out.println("s2 = "+s2);
        System.out.println("s3 = "+s3);
        System.out.println("--------------------");

        s1+=s2; // s1 is now JavaFoundations

        if (s1==s3) { //ингэж тэмдэгт мөрүүдийг шалгадаггүй
            System.out.println("Equal");
        }else{
            System.out.println("Not Equal");
        }

        if (s1.equals(s3)) {// Do this харин энэ бичиглэл зөв
            System.out.println("Equal");
        }else{
            System.out.println("Not Equal");
        }


        // compareTo()
        // Хэрэв 2 тэмдэгт мөр тэнцүү бол 0
        // Хэрэв compareTo() -г (s1) дуудсан тэмдэгт мөр нь параметр (s2) байдлаар
        //дамжсан мөрөөсөө бага бол сөрөг утга буцаана. Үгүй бол эерэг утга буцаадаг.

        if (s1.compareTo(s2)>0) { //харьцуулах үйлдэл
            System.out.println("Greater Than");
        }else{
            System.out.println("Less Than");
        }

        //charAt()
        char c;
        System.out.println(s1.charAt(2));
        
        //toUpperCase() and toLowerCase()
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toUpperCase()+s2.toLowerCase());

        //indexOf()  тэмдэгт мөрийн индексийг буцааж байна
        //indexOf(int ch)
        //indexOf(int ch, int index)
        //indexOf(String s)
        //indexOf(String s, int index)

        String s = "Winners never quit and quitters never win";
        System.out.println(s.indexOf("n"));
        System.out.println(s.indexOf("n", 5));
        System.out.println(s.indexOf("never"));
        System.out.println(s.indexOf("never", 15));

        //trim(), concat(), replace()
        String ss1 = " Java ";
        String ss2 = " Foundations ";
        String result1;
        result1 = ss1.concat(ss2);// тэмдэгт мөрийг нийлүүлдэг
        System.out.println(result1);

        result1 = result1.trim();// тэмдэгт мөрийн эхний үгийн хоосон зайг устгадаг
        System.out.println(result1);

        result1 = result1.replace('a', 'o');//тэмдэгт мөрийн үсгийг солих
        System.out.println(result1);
        System.out.println(result1.replace('a', 'o'));//бас ингэж бичиж болно шүү


        //StringTokenizer
        String ss = "Java String Tokenizer";
        StringTokenizer st = new StringTokenizer(ss);// үгийг тоолдог
        System.out.println("Tokens = "+st.countTokens());

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());// дараа дараагийн үгийг гаргах
        }
        
    }
}
