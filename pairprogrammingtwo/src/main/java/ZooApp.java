import java.io.*;
import java.util.List;

public class ZooApp {

    public static void main(String[] args) {
        Zoo botanico = new Zoo("Botanico");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
            ZooWriter zooWriter = new ZooWriter(writer);
            zooWriter.writeAnimals();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ZooAreas.txt"))) {
            ZooWriter zooWriter = new ZooWriter(writer);
            zooWriter.writeZooAreas();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("Animals.txt"))) {
            ZooReader animalReader = new ZooReader(reader);
            List<Animal> animals = animalReader.readAnimals();
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("ZooAreas.txt"))) {
            ZooReader animalReader = new ZooReader(reader);
            List<ZooArea> zooAreas = animalReader.readZooArea();
            for (ZooArea zooArea : zooAreas) {
                System.out.println(zooArea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        ZooArea areaOfMykures = new ZooArea(2, "Mykure Area");
//        areaOfMykures.addAnimal(mykure1);
//        areaOfMykures.addAnimal(mykure2);
//
//        // These animals cannot fit into the area anymore. Also, cannot add the same animal twice.
//        areaOfMykures.addAnimal(mykure3);
//        areaOfMykures.addAnimal(mykure1);
//        areaOfMykures.addAnimal(mykure1);
//
//        botanico.addArea(areaOfMykures);
//
//        System.out.println("---------------");
//        botanico.printDetailsOfAnimalsInAreasWithMoreThan(1);
//        System.out.println("---------------");
//        botanico.printDetailsOfAnimalsInAreasWithMoreThan(2);
//        System.out.println("---------------");
//
//        ZooArea slothAreas = new ZooArea(3, "Sloth Area");
//        slothAreas.addAnimal(sloth1);
//        slothAreas.addAnimal(sloth2);
//        slothAreas.addAnimal(sloth3);
//
//        botanico.addArea(slothAreas);
//        botanico.printDetailsOfAnimalsInAreasWithMoreThan(1);
    }

}
