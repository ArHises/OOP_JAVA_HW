package HW01;

public class Dog extends Animals{
    public Dog(String name, String sex, double age, double weight) {
        super(name, sex, age, weight);
    }
    public  Dog(String name, String sex, double age){
        this(name, sex, age,0.5);
    }
    public  Dog(String name, String sex){
        this(name, sex, 0.1,0.5);
    }
    public Dog(String name) {
        this(name, "male", 0.1,0.5);
    }
    public Dog() {
        this(String.format("DefaultName_%d", getLastId()), "male",0.1,0.5);
    }
    @Override
    public String speak() {
        return super.speak() + "Gav Gav!";
    }
}
