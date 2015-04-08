package LabTwo;

public class ArgumentDemo {

    public static void sub(String m){
    
        System.out.println("Function dotor ehleed: "+m);
        m="C++";
        System.out.println("Function dotor daraa: "+m);
    }
    
    public static void main(String args[]){
    
        String m = "Java";
        System.out.println("Damjuulahiin umnu: "+m);
        sub(m);
        System.out.println("Damjuulsanii daraa: "+m);
    }
}
