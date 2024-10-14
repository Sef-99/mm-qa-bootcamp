import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ZooWriter {
    private final BufferedWriter writer;

    public ZooWriter(BufferedWriter writer){
        this.writer = writer;
    }

    public void writeZooAreas() throws IOException {
        List<ZooArea> zooAreas = createZooAreas();
        for(ZooArea zooArea : zooAreas){
            writer.write("name: " + zooArea.getName() + ", ");
            writer.write("maxCapacity: " + zooArea.getMaxCapacity());
            writer.newLine();
        }
        System.out.println("Zoo areas created!");
    }


    public void writeAnimals() throws IOException {
        List<Animal> animals = createAnimals();
        for(Animal animal : animals){
            writer.write("species: " + animal.getSpecies() + ", ");
            writer.write("breed: " + animal.getBreed() + ", ");
            writer.write("name: " + animal.getName() + ", ");
            writer.write("birthYear: " + animal.getBirthYear());
            writer.newLine();
        }
        System.out.println("Animals created!");
    }

    private List<ZooArea> createZooAreas() {
        ZooArea areaOne = new ZooArea(4, "Area One");
        ZooArea areaTwo = new ZooArea(5, "Area Two");
        ZooArea areaThree = new ZooArea(2, "Area Three");
        List<ZooArea> zooAreas = new LinkedList<>();
        zooAreas.add(areaOne);
        zooAreas.add(areaTwo);
        zooAreas.add(areaThree);
        return zooAreas;
    }

    private List<Animal> createAnimals() {
        Animal mykure1 = new Mykure("Spike", "Mykure", "Spotted Mykure", 2018);
        Animal mykure2 = new Mykure("Venom", "Mykure", "Striped Mykure", 2016);
        Animal mykure3 = new Mykure("Flash", "Mykure", "Golden Mykure", 2019);


        Animal sloth1 = new Sloth("Lazy", "Sloth", "Brown-throated Sloth", 2015);
        Animal sloth2 = new Sloth("Sleepy", "Sloth", "Pygmy Three-Toed Sloth", 2013);
        Animal sloth3 = new Sloth("Chill", "Sloth", "Hoffmann's Two-Toed Sloth", 2016);

        List<Animal> animals = new LinkedList<>();
        animals.add(mykure1);
        animals.add(mykure2);
        animals.add(mykure3);
        animals.add(sloth1);
        animals.add(sloth2);
        animals.add(sloth3);
        return animals;
    }

}
