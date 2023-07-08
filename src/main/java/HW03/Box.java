package HW03;

public class Box{
    private final double weight;

    public Box(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "weight=" + weight
                + " kg" +
                '}';
    }
}
