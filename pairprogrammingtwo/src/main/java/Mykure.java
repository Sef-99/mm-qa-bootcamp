

public class Mykure extends AbstractAnimal {

    public Mykure(String name, String species, String breed, int birthYear) {
        super(name, species, breed, birthYear);
    }

    @Override
    public void eat() {
        System.out.printf("The mykure named %s eats alacrans, scorpions and cockroaches!", this.getName());
        System.out.println();
    }
}
