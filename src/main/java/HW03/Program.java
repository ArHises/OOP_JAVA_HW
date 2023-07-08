package HW03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        /*
        Создать класс Контейнер - Container.
        В контейнере могут быть ящики (класс Box).

        У каждого ящика есть вес.
        У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков, которые находятся в контейнере.

        1. Класс Контейнер должен быть Comparable. Сравнивать он должен по весам контейнера (чем меньше вес, тем меньше контейнер).
        2. Класс ContainerCountComparator - Comparator, который сравнивает контейнеры по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
        3. Класс контейнер должен быть Iterable - итерирование должно происходить по ящикам внутри контейнера.

        Container c = new Container(...);
        // ...
        for (Box box: c) {
        box - это контейнер
        }
         */

        // ------------ 1. Comparable: ------------

//        // Create first container
//        Container c1 = createContainer(5);
//        // Create second container
//        Container c2 = createContainer(5);
//
//        System.out.println(c1.getBoxes());
//        System.out.println("c1 Weight: " + c1.getWeight() + " kg");
//        System.out.println();
//
//        System.out.println(c2.getBoxes());
//        System.out.println("c2 Weight: " + c2.getWeight() + " kg");
//        System.out.println();
//
//        System.out.println("compareTo: " + c1.compareTo(c2));

        // ------------ 2. Comparator: ------------

//        // Create Container List
//        int containerNumber = 8;
//        List<Container> containerShip = new ArrayList<>();
//        Random rnd = new Random();
//        for (int i = 0; i < containerNumber; i++) {
//            containerShip.add(new Container());
//            int boxNumber = rnd.nextInt(1,10);
//            for (int j = 0; j < boxNumber; j++) {
//                containerShip.get(i).addBox(new Box(j));
//            }
//        }
//        // Print not sorted list
//        printList(containerShip, "Not Sorted");
//        // Use Comparator to sort
//        containerShip.sort(new ContainerCountComparator());
//        // Print sorted list
//        printList(containerShip, "Sorted");

        // ------------ 3. Iterable ------------

        // Create first container
        Container c1 = createContainer(5);

        for (Box box : c1) {
            System.out.println(box);
        }

    }

    public static Container createContainer(int amount){
        Random rnd = new Random();
        Container c = new Container();
        for (int i = 0; i < amount; i++) {
            c.addBox(new Box(rnd.nextInt(0,15)));
        }
        return c;
    }

    public static void printList(List<Container> list, String comment){
        System.out.print(comment + ": [ ");
        for (Container con : list ) {
            System.out.print(con.getBoxes().size() + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
