package Zoo;

import Animal.Animal;

import java.util.LinkedList;
import java.util.List;

public class ZooArea {
    private final int maxCapacity;
    private final List<Animal> animals;
    private final String name;

    public ZooArea(int maxCapacity, String name) {
        this.maxCapacity = maxCapacity;
        this.name = name;
        this.animals = new LinkedList<>();
    }

    public void addAnimal(Animal animal) throws IllegalArgumentException, IllegalStateException {
        if(animals.contains(animal)) {
            throw new IllegalArgumentException("The animal " + animal.getName() + " is already in the list!");
        }

        if (animals.size() < maxCapacity) {
            animals.add(animal);
            System.out.printf("Animal.Animal %s added!", animal.getName());
            System.out.println();
        } else {
            throw new IllegalStateException("Cannot add more animals to the Zoo.ZooArea.");
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Zoo.ZooArea{name='" + name + "', maxCapacity=" + maxCapacity + "}";
    }

}
