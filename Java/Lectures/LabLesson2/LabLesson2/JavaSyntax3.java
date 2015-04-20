package LabLesson2;

public class JavaSyntax3 {
    public static void main(String[] args){
        //while
        int count= 10;
        int sum=0;
        int i= 1;
        while (i<count) {
            sum++;
            i++;
        }
        System.out.println("while total="+sum);

        //do...while
        count =10;
        sum =0;
        i=1;
        do {
            sum++;
            i++;
        } while (i<count);
        
        System.out.println("do...while="+sum);

        //for
        count=10;
        sum=0;
        for ( i= 1; i < count; i++) {
            sum++;
        }
        System.out.println("for="+sum);
    }
}
