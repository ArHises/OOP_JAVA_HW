package HW02;

public class Program {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        /*
        Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования:

        Предположим, вы разрабатываете какую-то компьютерную игру, в которой есть несколько типов объектов (классов):
        1 - Здание (имеет текущий уровень здоровья)
        2 - Герой (имеет текущий уровень здоровья и текущий уровень магической энергии)
        3 - Нейтральный персонаж (имеет текущий уровень здоровья)
        Примеры того, как это может выглядеть:
        https://d3upx5peno0o6w.cloudfront.net/guides1png_1620826387.png
        https://xgm.guru/files/100/242011/HP-Bar.png

        Также у вас есть класс Render с методом showIndicator, который срабатывает при наведении мышки на объект и работает следующим образом:
        1 - Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
        2 - Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
        В качестве упрощения, пусть вывод на дисплей это запись информации в консоль.
        То есть вы пишете код, который выводит на консоль информацию.

        Подсказка: нужно ввести 2 интерфейса: наличие здоровья и наличие магической энергии.
        В классе Render проверять только на эти интерфейсы и выводить нужную информацию.
        Необходимо продумать, какие методы должны быть в интерфейсе.
.

        ЧТО ДЕЛАТЬ НЕ НУЖНО:
        Нельзя завязываться на конкретные классы. Предполагается, что таких классов очень много и они постоянно добавляются.

        Необязательные задания, которые не относятся к теме, но при сильном желании можно реализовать.

        * Со звездочкой : реализовать в консоли отображение индикатора.
        Например, при максимальном уровне здоровья 100 и текущем 40 можно отобразить вот такую ленточку: [xxxx ]

        ** С двумя звездочками : раскрасить вывод. Чем меньше здоровья, тем "краснее" цвет индикатора. Для полного здоровья - цвет зеленый.

         */

        Render render = new Render();

// BUILDING:
        Building building = new Building(100);
        building.setCurrentHealthPoint(50);

// HERO:
        Hero hero = new Hero(250, 150);
        hero.setCurrentHealthPoint(30);
        hero.setCurrentManaPoint(100);

// NEUTRAL:
        Neutral neutral = new Neutral(60);
        neutral.setCurrentHealthPoint(60);

        System.out.println("BUILDING stats:");
        render.showIndicator(building);
        System.out.println();

        System.out.println("HERO stats:");
        render.showIndicator(hero);
        System.out.println();

        System.out.println("NEUTRAL stats:");
        render.showIndicator(neutral);
        System.out.println();
    }

    static class Render {

        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            // Не должно быть упоминания конкретных классов!!!

            /*      HEALTH PRINT    */
            if (object instanceof Health) {
                int currentHealth = ((Health) object).getCurrentHealth();
                int maxHealth = ((Health) object).getMaxHealth();
                double percentage = (double) currentHealth / maxHealth * 100;

                String colorCode;
                if(percentage <= 25){
                    colorCode = ANSI_RED;
                } else if (25 < percentage && percentage <= 99) {
                    colorCode = ANSI_YELLOW;
                } else {
                    colorCode = ANSI_GREEN;
                }
                System.out.print("HP[");
                for (int i = 0; i < 100; i += 10) {
                    if (i < percentage) {
                        System.out.print(colorCode + "X");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print(ANSI_RESET + "] " + currentHealth + "/" + maxHealth);
                System.out.println();
            } else {
                System.out.println("--- NO-HEALTH ---");
            }

            /*     MAGIC-ENERGY PRINT       */
            if (object instanceof MagicEnergy) {
                int currentMagicEnergy = ((MagicEnergy) object).getCurrentMagicEnergy();
                int maxMagicEnergy = ((MagicEnergy) object).getMaxMagicEnergy();
                double percentage = (double) currentMagicEnergy / maxMagicEnergy * 100;

                System.out.print("ME[");
                for (int i = 0; i < 100; i += 10) {
                    if (i < percentage) {
                        System.out.print(ANSI_BLUE + "O");
                    } else {
                        System.out.print(ANSI_RESET + " ");
                    }
                }
                System.out.print("] " + currentMagicEnergy + "/" + maxMagicEnergy);
                System.out.println();
            } else {
                System.out.println("--- NO-MAGIC-ENERGY ---");
            }
        }
    }

    static class Building implements Health {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getMaxHealth() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return currentHealthPoint;
        }

        // FIXME: 29.06.2023 Дописать нужное

    }

    static class Hero implements Health, MagicEnergy {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        private int maxManaPoint; // максимально количество магический энергии
        private int currentManaPoint; // текущее количество магический энергии

        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }

        @Override
        public int getMaxHealth() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return currentHealthPoint;
        }

        @Override
        public int getMaxMagicEnergy() {
            return maxManaPoint;
        }

        @Override
        public int getCurrentMagicEnergy() {
            return currentManaPoint;
        }

        // FIXME: 29.06.2023 Дописать нужное
    }

    static class Neutral implements Health {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getMaxHealth() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return currentHealthPoint;
        }

        // FIXME: 29.06.2023 Дописать нужное
    }
}
