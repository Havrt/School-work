// Package: animals
package animals;

abstract class Animal {
    private String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name) {
        this(name, 0);
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food + ".");
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public Dog(String name, String breed) {
        this(name, 0, breed);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public void fetch() {
        System.out.println("Fetching the ball.");
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public Cat(String name, String color) {
        this(name, 0, color);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void scratch() {
        System.out.println("Scratching the furniture.");
    }
}

class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public Bird(String name, boolean canFly) {
        this(name, 0, canFly);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }

    public void fly() {
        if (canFly) {
            System.out.println("Flying high.");
        } else {
            System.out.println("Cannot fly.");
        }
    }
}

// Package: vehicles
package vehicles;

abstract class Vehicle {
    private String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public Vehicle(String brand) {
        this(brand, 2020);
    }

    public abstract void start();

    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}

class Car extends Vehicle {
    private int doors;

    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }

    public Car(String brand, int doors) {
        this(brand, 2020, doors);
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    public void honk() {
        System.out.println("Honk honk!");
    }
}

class Bicycle extends Vehicle {
    private int gears;

    public Bicycle(String brand, int year, int gears) {
        super(brand, year);
        this.gears = gears;
    }

    public Bicycle(String brand, int gears) {
        this(brand, 2020, gears);
    }

    @Override
    public void start() {
        System.out.println("Bicycle started.");
    }

    public void ringBell() {
        System.out.println("Ring ring!");
    }
}

// Package: shapes
package shapes;

interface Shape {
    double getArea();
    double getPerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        this(1.0);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side) {
        this(side, side);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// Package: main
package main;

import animals.*;
import vehicles.*;
import shapes.*;

public class Main {
    public static void main(String[] args) {
        // Animals
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.makeSound();
        dog.eat("bones");

        Cat cat = new Cat("Whiskers", "Black");
        cat.makeSound();
        cat.scratch();

        Bird bird = new Bird("Tweety", true);
        bird.makeSound();
        bird.fly();

        // Vehicles
        Car car = new Car("Toyota", 4);
        car.start();
        car.honk();

        Bicycle bicycle = new Bicycle("Giant", 21);
        bicycle.start();
        bicycle.ringBell();

        // Shapes
        Circle circle = new Circle(5.0);
        System.out.println("Circle Area: " + circle.getArea());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
    }
}