package pairprogramming;

public class Hippo extends Animal{
    private static int numberOfHippos;

    public Hippo(String name, String breed){
        super(name,breed);
        numberOfHippos++;
    }

    public static int getNumberOfHippos() {
        return numberOfHippos;
    }

    @Override
    public void makeSound(){
        System.out.printf("The Hippo named %s of breed %s says Gong Gong!",
                this.getName(), this.getBreed());
        System.out.println();
    }
}
