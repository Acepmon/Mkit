package LabThree;

public class ExampleThis {
    String name;
    int age;
    String gender;
    
    public ExampleThis(){
    
        this.name = "null";
        this.age = 0;
        this.gender = "null";
    }

    public ExampleThis(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void miniiTuhai(){
        System.out.println("Ner = "+name);
        System.out.println("Nas = "+age);
        System.out.println("Huis = "+gender);
    }
}
