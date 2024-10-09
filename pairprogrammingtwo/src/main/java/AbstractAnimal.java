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

    @Override
    public int getBirthYear() {
        return this.birthYear;
    }
}
