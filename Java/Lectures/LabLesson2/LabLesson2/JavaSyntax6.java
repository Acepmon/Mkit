package LabLesson2;


public class JavaSyntax6 {
    public static void main(String[] args){
        //ARRAY  буюу массивийн тухай
            //ARRAY массивийг хэрэглэх нь
        System.out.println("ARRAY"+"--------------------------------");
        int[] array1= new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] array2= new int[array1.length];
        System.out.println("array1 urt = "+array1.length);
        int i;
        int j=0;
        //Copy array1 to array2 going backwards in array1
        for ( i= (array1.length-1); i >=0; i--) {
            array2[j]=array1[i];
            j++;
        }

        //Print out results using array2
        for ( j= 0; j < array2.length; j++) {
            System.out.print(array2[j]);
            if (j<(array2.length-1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
        // Copying Arrays
        char[] copyFrom= {'a','b','c','d','e',
                         'f','g','h','i','j',
                         'l','m','n','o','p' };
        char[] copyTo=new char[12];

        System.arraycopy(copyFrom, 0, copyTo, 0, 7);
        System.out.println(new String(copyTo));
        
    }
}
