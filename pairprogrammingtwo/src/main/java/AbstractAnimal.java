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

        Zoo zoo = new Zoo("Madagascar Zoo");

        // Crear las áreas
        ZooArea area1 = new ZooArea(7);
        ZooArea area2 = new ZooArea(5);



        // Agregar las áreas al zoo
        zoo.addArea(area1);
        zoo.addArea(area2);

        // Filtrar áreas con más de 1 animal
        zoo.filterAreasWithMoreThanXAnimals(1);
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
