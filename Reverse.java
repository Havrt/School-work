import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine();

        // Reverse the string using StringBuilder
        String reversedString = new StringBuilder(originalString).reverse().toString();

        // Print the original and reversed strings
        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}