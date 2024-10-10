import java.util.ArrayList;
import java.util.List;

public class ZooArea {
    private int maxCapacity;
    private List<Animal> animals;

    public ZooArea(int capacidadMaxima) {
        this.maxCapacity = maxCapacity;
        this.animals = new ArrayList<>();
    }

    public boolean addAnimal(Animal animal) {
        if (animals.size() < maxCapacity) {
            animals.add(animal);
            return true;
        } else {
            System.out.println("No se puede agregar más animales , Capacidad máxima de la area alcanzada.");
            return false;
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
