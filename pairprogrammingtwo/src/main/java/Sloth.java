public class Sloth extends AbstractAnimal {

    public Sloth(String name, String species, String breed, int birthYear) {
        super(name, species, breed, birthYear);
    }

    @Override
    public void eat() {
        System.out.printf("The sloth named %s eats twigs, buds and leaves!", this.getName());
        System.out.println();
    }
}
