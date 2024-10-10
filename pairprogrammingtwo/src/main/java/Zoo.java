import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {
    private String name;
    private List<ZooArea> areas;

    public Zoo(String nombre) {
        this.name = name;
        this.areas = new ArrayList<>();
    }

    public void addArea(ZooArea area) {
        areas.add(area);
    }

    public void filterAreasWithMoreThanXAnimals(int x) {
        List<ZooArea> areasFiltered = areas.stream()
                .filter(area -> area.getAnimals().size() > x)
                .collect(Collectors.toList());

        for (ZooArea area : areasFiltered) {
            System.out.println("Area with more than " + x + " animals:");
            area.getAnimals().forEach(animal -> System.out.println(animal));
        }
    }
}

