package HW01;

public class Chicken extends Animals{
    public Chicken(String name, String sex, double age, double weight) {
        super(name, sex, age, weight);
    }
    public  Chicken(String name, String sex, double age){
        this(name, sex, age,0.5);
    }
    public  Chicken(String name, String sex){
        this(name, sex, 0.1,0.5);
    }
    public Chicken(String name) {
        this(name, "male", 0.1,0.5);
    }
    public Chicken() {
        this(String.format("DefaultName_%d", getLastId()), "male",0.1,0.5);
    }

    @Override
    public String speak() {
        return super.speak() + "Kukariku!";
    }
}

