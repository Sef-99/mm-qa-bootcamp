import Animal.Animal;
import Zoo.Zoo;
import Zoo.ZooArea;
import Zoo.ZooReader;
import Zoo.ZooWriter;

import java.io.*;
import java.util.List;

public class ZooApp {

    public static void main(String[] args) {
        Zoo botanico = new Zoo("Botanico");

        createZooFiles();

        List<Animal> animals = readAnimalsFromFile();

        List<ZooArea> zooAreas = readZooAreasFromFile();

        addAnimalsToZooAreas(animals, zooAreas);

        Animal animalToTest = animals.get(0);
        ZooArea zooAreaToTest = zooAreas.get(0);
        testAddDuplicateToZooArea(animalToTest, zooAreaToTest);

        botanico.addArea(zooAreaToTest);
        botanico.printDetailsOfAnimalsInAreasWithMoreThan(2);

    }

    private static void testAddDuplicateToZooArea(Animal animalToTest, ZooArea zooAreaToTest) {
        try {
            zooAreaToTest.addAnimal(animalToTest);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Failed to add " + animalToTest.getName() + " to a zoo area "
                    + zooAreaToTest.getName() + ": " + e.getMessage());
        }
    }

    private static void addAnimalsToZooAreas(List<Animal> animals, List<ZooArea> zooAreas) {
        for (Animal animal : animals) {
            for (ZooArea zooArea : zooAreas) {
                try {
                    zooArea.addAnimal(animal);
                    break;
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Failed to add " + animal.getName() + " to a zoo area "
                            + zooArea.getName() + ": " + e.getMessage());
                }
            }
        }
    }

    private static List<ZooArea> readZooAreasFromFile() {
        List<ZooArea> zooAreas = List.of();
        try (BufferedReader reader = new BufferedReader(new FileReader("ZooAreas.txt"))) {
            ZooReader zooReader = new ZooReader(reader);
            zooAreas = zooReader.readZooArea();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return zooAreas;
    }

    private static List<Animal> readAnimalsFromFile() {
        List<Animal> animals = List.of();
        try (BufferedReader reader = new BufferedReader(new FileReader("Animals.txt"))) {
            ZooReader zooReader = new ZooReader(reader);
            animals = zooReader.readAnimals();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return animals;
    }

    private static void createZooFiles() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
            ZooWriter zooWriter = new ZooWriter(writer);
            zooWriter.writeAnimals();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ZooAreas.txt"))) {
            ZooWriter zooWriter = new ZooWriter(writer);
            zooWriter.writeZooAreas();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
