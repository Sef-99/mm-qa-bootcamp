package pairprogramming;

public class Cat extends Animal{
    private static int numberOfCats;

    public Cat(String name, String breed) {
        super(name, breed);
        numberOfCats++;
    }

    public static int getNumberOfCats() {
        return numberOfCats;
    }

    @Override
    public void makeSound() {
        System.out.printf("The cat named %s of breed %s meows!", this.getName(), this.getBreed());
        System.out.println();
    }

}
