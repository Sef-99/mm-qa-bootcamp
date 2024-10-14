import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ZooReader {
    private final BufferedReader bufferedReader;

    public ZooReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public List<ZooArea> readZooArea() throws IOException {
        List<ZooArea> zooAreas = new LinkedList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            ZooArea zooArea = parseZooArea(line);
            if (zooArea != null) {
                zooAreas.add(zooArea);
            }
        }
        System.out.println("Zoo areas parsed successfully.");
        return zooAreas;
    }

    private ZooArea parseZooArea(String line) {
        line = line.trim();
        String[] tokens = line.split(", ");

        String name = null;
        int maxCapacity = -1;

        for (String token : tokens) {
            String[] keyValue = token.split(": ");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "name":
                    name = value;
                    break;
                case "maxCapacity":
                    maxCapacity = Integer.parseInt(value);
                    break;
                default:
                    break;
            }
        }
        if(name == null || maxCapacity == -1) {
            return null;
        }
        return new ZooArea(maxCapacity, name);
    }

    public List<Animal> readAnimals() throws IOException {
        List<Animal> animals = new LinkedList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Animal animal = parseAnimal(line);
            if (animal != null) {
                animals.add(animal);
            }
        }
        System.out.println("Animals parsed successfully.");
        return animals;
    }

    private Animal parseAnimal(String line) {
        line = line.trim();
        String[] parts = line.split(", ");

        String species = null;
        String breed = null;
        String name = null;
        int birthYear = -1;

        for (String part : parts) {
            String[] keyValue = part.split(": ");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "species":
                    species = value;
                    break;
                case "breed":
                    breed = value;
                    break;
                case "name":
                    name = value;
                    break;
                case "birthYear":
                    birthYear = Integer.parseInt(value);
                    break;
            }
        }

        if (species == null || breed == null || name == null || birthYear == -1) {
            return null;
        }

        return switch (species) {
            case "Mykure" -> new Mykure(species, breed, name, birthYear);
            case "Sloth" -> new Sloth(species, breed, name, birthYear);
            default -> null;
        };
    }
}
