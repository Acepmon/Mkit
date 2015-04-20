
package LabLesson2;

public class JavaSyntax2 {
    public static void main(String[] args){
        double salary;
        int numberOfDays;
        char aLetter;
        boolean found;
        String S="Hi all, it is Java lesson";

        salary=55000.0;
        numberOfDays=7;
        aLetter='A';
        found=true;

        final double SALARY=55000.0;
        final int MAX_LENGTH=10;

        int postCount=10;
        int preCount=10;
        postCount++;
        ++preCount;
        System.out.println(postCount);
        System.out.println(preCount);
        
        int three=3;
        int two=2;
        double result;
        result=1.5+three/two;
        
        result=1.5+(double)three/two;
        System.out.println("result="+result);
    }
}
