// Animal class
class Animal {
    public int age;
    public String gender;

    // Constructor for Animal class
    public Animal(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    // Method to check if the animal is a mammal
    public void isMammal() {
        System.out.println("This is a public method isMammal() from class Animal.");
    }

    // Method for mating behavior
    public void mate() {
        System.out.println("This is a public method mate() from class Animal.");
    }

    // Main method
    public static void main(String[] args) {
        // Create an Animal object
        Animal myAnimal = new Animal(5, "Male");
        System.out.println("Animal object created with age: " + myAnimal.age + " and gender: " + myAnimal.gender);

        // Call public methods from Animal class
        myAnimal.isMammal();
        myAnimal.mate();

        // Create a Fish object
        Fish myFish = new Fish(2, "Female", 3);
        System.out.println("Fish object created with age: " + myFish.age + ", gender: " + myFish.gender);

        // Note: Private methods in Fish class cannot be called directly here.

        // Create a Zebra object
        Zebra myZebra = new Zebra(4, "Female", true);
        System.out.println("Zebra object created with age: " + myZebra.age + ", gender: " + myZebra.gender + ", is_wild: " + myZebra.is_wild);

        // Call public methods from Zebra class
        myZebra.run();
    }
}

// Fish class as a subclass of Animal
class Fish extends Animal {
    private int sizeInFeet;

    // Constructor for Fish class
    public Fish(int age, String gender, int sizeInFeet) {
        super(age, gender); // Call the constructor of the superclass (Animal)
        this.sizeInFeet = sizeInFeet;
    }

    // Private method for Fish class
    private void canEat() {
        System.out.println("This is a private method canEat() from class Fish.");
    }
}

// Zebra class as a subclass of Animal
class Zebra extends Animal {
    public boolean is_wild;

    // Constructor for Zebra class
    public Zebra(int age, String gender, boolean is_wild) {
        super(age, gender); // Call the constructor of the superclass (Animal)
        this.is_wild = is_wild;
    }

    // Public method for Zebra class
    public void run() {
        System.out.println("This is a public method run() from class Zebra.");
    }
}