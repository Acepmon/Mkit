package LabLesson2;

public class JavaSyntax4 {
    public static void main(String[] args){
        int i;
        int count=1;
        //break
        int stopAt = 5;
        for ( i= 0; i < 10; i++) {
            if(i == stopAt){
                break;
            }
            System.out.println("break "+i);
        }

        //continue
        count = 10;
        for ( i = 0; i < count; i++) {
            if(i%2==0){
                        continue;
                        }
            System.out.println("continue "+i);
        }

        //switch
        int day=5;
        switch(day){
            case 1:
                System.out.println("Today is Monday");break;
            case 2:
                System.out.println("Today is Tuesday");break;
            case 3:
                System.out.println("Today is Wednesday");break;
            case 4:
                System.out.println("Today is Thursday");break;
            case 5:
                System.out.println("Today is Friday");break;
            case 6:
                System.out.println("Today is Saturday");break;
            case 7:
                System.out.println("Today is Sunday");break;
        }

        //Ternary Operator logicalExpression ? expression1 : expression2
        int myAge = 34;
        int yourAge = 25;
        System.out.println("The youngest is "+(yourAge>myAge ? myAge :yourAge ));
    }
}
