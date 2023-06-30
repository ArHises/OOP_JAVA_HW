package HW01;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        /*

        Нужно создать несколько классов животных:
        1. Пес (Собака)
        2. Кот (Кошка)
        3. ... придумать еще парочку

        Каждое животное имеет: (поля)
        1. Имя (кличка)
        2. Возраст
        3. ... придумать еще какие-то параметры

        Каждое животное может: (методы)
        1. Подавать голос
        2. Питаться (съедает какое-то количество еды, переданное в метод)
        3. Двигаться
        4. ... все, что сумеете придумать

        Нужно выделить базовый тип с общими атрибутами, инкапсулировать то, что является внутренним, внурь класса.
        Создать массив с животными и в цикле заставить их поесть (какое-то количество еды) и заставить подать голос.

        Придумать свою структуру с наследованием по аналогии с животными и банковскими счетами.

         */

        Animals dog1 = new Dog("Sharik", "male", 3, 12);
        Animals cat1 = new Cat("Boris", "male", 8, 6);
        Animals chicken1 = new Chicken("Liza", "female");
        Animals cow1 = new Cow("Milka");

        ArrayList<Animals> myFarm = new ArrayList<>(Arrays.asList(dog1, cat1, chicken1, cow1));

        for (Animals ani : myFarm) {
            System.out.println("-----");
            System.out.println(ani.toString());
            System.out.println(ani.speak());
            ani.eat("Spaghetti", 0.2);
            System.out.println(ani.toString());
        }
    }
}
