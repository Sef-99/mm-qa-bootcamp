package pairprogramming;

public abstract class Animal {
    private final String name;
    private final String breed;
    private static int numberOfAnimals;

    Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
        numberOfAnimals++;
    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}
