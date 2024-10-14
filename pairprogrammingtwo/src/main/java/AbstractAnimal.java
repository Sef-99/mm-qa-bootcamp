import java.time.Year;

public abstract class AbstractAnimal implements Animal {
    private final String species;
    private final String breed;
    private final String name;
    private final int birthYear;

    public AbstractAnimal(String name, String species, String breed, int birthYear) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.birthYear = birthYear;
    }

    @Override
    public String getSpecies() {
        return this.species;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - this.birthYear;
    }


    @Override
    public String toString() {
        return "Animal Details:\n" +
                "  Species    : " + getSpecies() + "\n" +
                "  Breed      : " + getBreed() + "\n" +
                "  Name       : " + getName() + "\n" +
                "  Age        : " + getAge() + " years old";
    }


}
