

public class ZooApp {

    public static void main(String[] args) {
        Zoo botanico = new Zoo("Botanico");

        Mykure mykure1 = new Mykure("Spike", "Mykure", "Spotted Mykure", 2018);
        Mykure mykure2 = new Mykure("Venom", "Mykure", "Striped Mykure", 2016);
        Mykure mykure3 = new Mykure("Flash", "Mykure", "Golden Mykure", 2019);


        Sloth sloth1 = new Sloth("Lazy", "Sloth", "Brown-throated Sloth", 2015);
        Sloth sloth2 = new Sloth("Sleepy", "Sloth", "Pygmy Three-Toed Sloth", 2013);
        Sloth sloth3 = new Sloth("Chill", "Sloth", "Hoffmann's Two-Toed Sloth", 2016);


        ZooArea areaOfMykures = new ZooArea(2, "Mykure Area");
        areaOfMykures.addAnimal(mykure1);
        areaOfMykures.addAnimal(mykure2);

        // These animals cannot fit into the area anymore. Also, cannot add the same animal twice.
        areaOfMykures.addAnimal(mykure3);
        areaOfMykures.addAnimal(mykure1);
        areaOfMykures.addAnimal(mykure1);

        botanico.addArea(areaOfMykures);

        System.out.println("---------------");
        botanico.printDetailsOfAnimalsInAreasWithMoreThan(1);
        System.out.println("---------------");
        botanico.printDetailsOfAnimalsInAreasWithMoreThan(2);
        System.out.println("---------------");

        ZooArea slothAreas = new ZooArea(3, "Sloth Area");
        slothAreas.addAnimal(sloth1);
        slothAreas.addAnimal(sloth2);
        slothAreas.addAnimal(sloth3);

        botanico.addArea(slothAreas);
        botanico.printDetailsOfAnimalsInAreasWithMoreThan(1);
    }

}
