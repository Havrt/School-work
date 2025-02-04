import java.util.InputMismatchException;
import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Metric Converter!");
            System.out.println("1. Convert Pounds to Kilograms");
            System.out.println("2. Convert Kilograms to Pounds");
            System.out.println("3. Exit");
            System.out.print("Please choose an option (1, 2, or 3): ");

            int choice = 0;
            while (true) {
                try {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 3) {
                        break; // Valid choice, exit loop
                    } else {
                        System.out.print("Invalid choice. Please enter 1, 2, or 3: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter a number (1, 2, or 3): ");
                    scanner.next(); // Clear invalid input
                }
            }

            // Exit condition
            if (choice == 3) {
                running = false;
                System.out.println("Thank you for using the Metric Converter. Goodbye!");
                break; // Exit the loop
            }

            double weight = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter the weight to convert: ");
                    weight = scanner.nextDouble();
                    if (weight >= 0) {
                        validInput = true; // Valid weight, exit loop
                    } else {
                        System.out.println("Weight cannot be negative. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Perform conversion based on user choice
            if (choice == 1) {
                double kilograms = poundsToKilograms(weight);
                System.out.printf("%.2f lbs = %.2f kg%n", weight, kilograms);
            } else if (choice == 2) {
                double pounds = kilogramsToPounds(weight);
                System.out.printf("%.2f kg = %.2f lbs%n", weight, pounds);
            }
        }

        scanner.close(); // Close the scanner
    }

    // Conversion method: Pounds to Kilograms
    public static double poundsToKilograms(double pounds) {
        return pounds * 0.45359237;
    }

    // Conversion method: Kilograms to Pounds
    public static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462262;
    }
}