package pairprogramming;

public class Main {

    public static void main(String[] args) {
        Animal michifus = new Cat("Michifus", "Siamese");
        Animal octavius = new Giraffe("Octavious", "African");
        Animal gloria = new Hippo("Gloria","Pigmy");
        Animal melman = new Giraffe("Melman", "Masai");
        Animal[] listOfAnimals = {michifus, gloria, melman, octavius};

        makeSounds(listOfAnimals);

        System.out.println("============");

        countTotalAnimals();

    }

    private static void countTotalAnimals() {
        System.out.printf("Total amount of animals is: %d", Animal.getNumberOfAnimals());
        System.out.println();
        System.out.printf("Total amount of cats is: %d", Cat.getNumberOfCats());
        System.out.println();
        System.out.printf("Total amount of hippos is: %d", Hippo.getNumberOfHippos());
        System.out.println();
        System.out.printf("Total amount of giraffes is: %d", Giraffe.getNumberOfGiraffes());
    }

    private static void makeSounds(Animal[] listOfAnimals) {
        System.out.println("The animals make their sounds!");
        for(Animal animal : listOfAnimals) {
            animal.makeSound();
        }
    }
}
