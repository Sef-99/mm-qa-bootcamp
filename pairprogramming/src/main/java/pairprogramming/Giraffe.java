package pairprogramming;

public class Giraffe extends Animal {
    private static int numberOfGiraffes;

    public Giraffe(String name, String breed){
        super (name, breed);
        numberOfGiraffes++;
    }

    public static int getNumberOfGiraffes() {
        return numberOfGiraffes;
    }

    @Override
    public void makeSound() {
        System.out.printf("The Giraffe named %s of breed %s says Hom Hom!",
                this.getName(), this.getBreed());
        System.out.println();
    }
}
