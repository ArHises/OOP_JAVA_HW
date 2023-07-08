package HW03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Container implements Comparable<Container> , Iterable<Box>{
    private final List<Box> boxes;

    public Container() {
        this.boxes = new ArrayList<>();
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void addBox(Box box){
        boxes.add(box);
    }

    public double getWeight(){
        double sum = 0;
        for (Box box: this.boxes ) {
            sum += box.getWeight();
        }
        return sum;
    }

    @Override
    public int compareTo(Container container) {
        return Integer.compare((int) this.getWeight(), (int) container.getWeight());
    }

    @Override
    public Iterator<Box> iterator() {
        return new ContainerIterator(boxes);
    }
}
