package HW01;

import java.util.Objects;
import java.util.Random;

public abstract class Animals {
    enum State {
        asleep, awake
    }
    private State state;
    private String name;
    private double weight;
    private final String sex;
    private final double age;
    private final long id;
    private static int lastId = 0;

    /**
     * Creating an animal.
     *
     * @param name is animal name.
     * @param sex is animal sex.
     * @param age is animal age.
     * @param weight is animal weight.
     */
    public Animals(String name, String sex, double age, double weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.id = lastId;
        lastId++;
        state = State.awake;
    }
    public  Animals(String name, String sex, double age){
        this(name, sex, age,0.5);
    }
    public  Animals(String name, String sex){
        this(name, sex, 0.1,0.5);
    }
    public Animals(String name) {
        this(name, "male", 0.1,0.5);
    }
    public Animals() {
        this(String.format("DefaultName_%d", lastId), "male",0.1,0.5);
    }
    public void setName(String name) {
        this.name = name;
    }

    public static int getLastId() {
        return lastId;
    }

    public long getId() {
        return id;
    }
    public String getSex() {
        return sex;
    }
    public double getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }
    public double getAge() {
        return age;
    }
    public State getState() { // (Awake / Asleep)
        return state;
    }
    public String speak(){
        return String.format(name + " say: ");
    }
    public void eat(String foodName, double amount) {
        if (state == State.awake) {
            System.out.printf("%s eats %.2f kg of %s%n", name, amount, foodName);
            this.weight += amount;
        } else {
            System.out.println(name + " is sleeping...");
        }
    }
     public void move(){
        if (state == State.awake){
            System.out.println(name + " is moving around...");
            this.weight -= 0.1;
        } else {
            System.out.println(name + " is sleeping...");
        }
     }
    public void status() {
        if (this.state == State.asleep) {
            this.getAwake();
            this.state = State.awake;
        } else {
            this.getAsleep();
            this.state = State.asleep;
        }
        System.out.println();
    }
    private void getAwake() {
        System.out.println(name + " is getting awake!");
    }
    private void getAsleep() {
        System.out.println(name + " is falling asleep...");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return this.id == animals.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", status='" + state + '\'' +
                ", age=" + age + "y.o"+
                ", weight=" + weight + "kg" +
                '}';
    }
}
