
import java.util.LinkedList;
import java.util.List;


public class Zoo {
    private final String name;
    private final List<ZooArea> zooAreas;

    public Zoo(String name) {
        this.name = name;
        zooAreas = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addArea(ZooArea area) {
        zooAreas.add(area);
    }

    public void printDetailsOfAnimalsInAreasWithMoreThan(int amountOfAnimals) {
        List<ZooArea> filteredAreas = zooAreas.stream()
                .filter(area -> area.getAnimals().size() > amountOfAnimals)
                .toList();

        if (filteredAreas.isEmpty()) {
            System.out.printf("No areas with more than %d animals found\n", amountOfAnimals);
            return;
        }

        System.out.println("Area with more than " + amountOfAnimals + " animals: ");
        for (ZooArea area : filteredAreas) {
            System.out.println(area.getName() + ": ");
            area.getAnimals().forEach(System.out::println);
        }
    }

}

