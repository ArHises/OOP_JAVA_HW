package HW04;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public List<T> getList(){
        return this.box;
    }

    public void add(T fruit){
        this.box.add(fruit);
    }
     public double getWeight(){
        double sumWeight = 0;
         for ( Fruit f : box) {
             sumWeight += f.getWeight();
         }
         return sumWeight;
     }

    public void moveTo(Box<? super T> newBox) {
        newBox.box.addAll(this.box);
        box.clear();
    }
}
