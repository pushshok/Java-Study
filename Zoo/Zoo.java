/**
 * Java 1. Homework #6.
 * @author Zdibnyak Maxim
 * @version_1 25.12.2021
 */

package ru.geekbrains.home_work_app;

public class Zoo {
    public static void main(String[] args) {
        int barrier = 100;
        int animalNumber = 0;
        IAnimal cat = new Cat("Murzik", 99, 150);
        IAnimal dog = new Dog("Bobik", 99, 199);
        IAnimal cat1 = new Cat("Barsik", 300, 0);
        IAnimal dog1 = new Dog("Tuzik", 150, 99);
        IAnimal[] animals = {cat, dog, cat1, dog1};

        for (IAnimal animal : animals) {
            if (animal.run(barrier) == true) {
                System.out.println(animal.voice() + " ran " + barrier + " m.");
            } else {
                System.out.println(animal.voice() + " didn't master " + barrier + " m.");
            }

            if (animal.swim(barrier) == true) {
                System.out.println(animal.voice() + " swam " + barrier + " m.");
            } else {
                System.out.println(animal.voice() + " safely drowned.");
            }
            System.out.println(animal);
            animalNumber++;
        }

        System.out.println("The number of animals involved in the inhuman experiment was " + animalNumber + " individuals.");
    }
}

interface IAnimal {
    boolean swim(int barrier);
    boolean run (int barrier);
    String voice();
}

abstract class Animals implements IAnimal {
    protected String name;
    protected int runDistance;
    protected int swimDistance;

    Animals (String name, int runDistance, int swimDistance){
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    @Override
    public String voice() {
        return this.name;
    }

    @Override
    public boolean run(int barrier) {
        if (this.runDistance >= barrier) {
            return true;
        } else return false;
    }

    @Override
    public boolean swim(int barrier) {
        if (this.swimDistance >= barrier) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return (name + ", " + runDistance + ", " + swimDistance);
    }
}

class Cat extends Animals {
    private String swimDistance;


    // Не могу переопределить тип int в тип стринг для конструктора, это возможно?
    Cat(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
        this.swimDistance = "Cats can't swim!";
    }

//    public void setDistance(int swimDistance) {
//        String swimDist;
//        swimDist = Integer.toString(swimDistance);
//        swimDist =
//        this.swimDistance = "Cats can't swim!";
//    }
//        public <swimDistance> String setDistance(swimDistance)
//        public static String valueOf(int swimDistance);
//        Integer.toString(int swimDistance);
//        swimDistance = "Cats can't swim!";
//        return swimDistance;
//    }

    @Override
    public boolean swim(int barrier) {
        return false;
    }

}

class Dog extends Animals  {
    Dog (String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
    }
}
