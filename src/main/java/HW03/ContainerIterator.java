package HW03;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ContainerIterator implements Iterator<Box> {
    private final List<Box> boxes;
    private int position;
    private int lastReturn;

    public ContainerIterator(List<Box> boxes) {
        this.boxes = boxes;
        this.position = 0;
        this.lastReturn = 0;
    }

    @Override
    public boolean hasNext() {
        return position < boxes.size();
    }

    @Override
    public Box next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        lastReturn = position + 1;
        return boxes.get(position++);
    }
}
