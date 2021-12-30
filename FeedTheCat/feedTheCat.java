package ru.geekbrains.home_work_app;

class feedTheCat {

    public static void main(String[] args) {
        Cat[] allMyCats = new Cat[6];
        allMyCats[0] = new Cat("Barsik", 15);
        allMyCats[1] = new Cat("Murzik", 5);
        allMyCats[2] = new Cat("Marsik", 15);
        allMyCats[3] = new Cat("Basik", 10);
        allMyCats[4] = new Cat("Busik", 45);
        allMyCats[5] = new Cat("Musik", 15);

        Plate plate = new Plate(100);

        for (Cat myCat : allMyCats) {
            System.out.println("Food in the plate: " + plate);
            myCat.eat(plate);
            System.out.println(myCat);
            plate.increaseFood(myCat);
        }

        System.out.println("Added food to feed all the cats. Food in the plate: " + plate);

        for (Cat myCat : allMyCats) {
            System.out.println("Food in the plate: " + plate);
            myCat.eat(plate);
            System.out.println(myCat);
            plate.increaseFood(myCat);
        }

    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    int getAppetite() {
        return this.appetite;
    }

    boolean getFull() {
        return this.full;
    }

    boolean eat(Plate plate) {
        if (this.full) {
            System.out.println(this.name + " is not hungry!");
            return this.full;
        } else {
            this.full = plate.decreaseFood(appetite);
            return this.full;
        }
    }

    @Override
    public String toString() {
        return "Cat: " + name + " has appetite: " + appetite + " and if the cat hungry: " + !full;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    int getFood () {
        return food;
    }

    void setFood(int food) {
        this.food = food;
    }

    void increaseFood(Cat cat) {
        if (cat.getFull() == false) {
            this.food += 100;
        }
    }

    boolean decreaseFood(int food) {
        if (this.food - food < 0) {
            return false;
        } else {
            this.food = this.food - food;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}