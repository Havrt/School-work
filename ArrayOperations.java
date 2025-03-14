import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ArrayOperations {

    // Function to create an array of random integers between 0 and 100
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(101); // Random integer between 0 and 100
        }
        return array;
    }

    // Function to write an array to a file, one integer per line
    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(num + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Function to read integers from a file into an array
    public static int[] readFileToArray(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int[] array = new int[100]; // Assuming a maximum of 100 integers
            int index = 0;
            while ((line = reader.readLine()) != null) {
                array[index++] = Integer.parseInt(line);
            }
            // Resize the array to the actual number of integers read
            int[] resizedArray = new int[index];
            System.arraycopy(array, 0, resizedArray, 0, index);
            return resizedArray;
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return new int[0]; // Return an empty array in case of error
        }
    }

    // Function to sort an array using bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Swap array[i-1] and array[i]
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // Main function to handle user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Generate an array of random integers and store it in a file");
        System.out.println("2. Read an existing file, sort it, and store the sorted array in another file");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Option 1: Generate a random array and store it in a file
            System.out.print("Enter the length of the array: ");
            int arrayLength = scanner.nextInt();
            System.out.print("Enter the filename to save the array: ");
            String filename = scanner.next();

            int[] array = createRandomArray(arrayLength);
            writeArrayToFile(array, filename);
            System.out.println("Array written to file: " + filename);

        } else if (choice == 2) {
            // Option 2: Read a file, sort the array, and store it in another file
            System.out.print("Enter the filename to read the array from: ");
            String inputFilename = scanner.next();
            System.out.print("Enter the filename to save the sorted array: ");
            String outputFilename = scanner.next();

            int[] array = readFileToArray(inputFilename);
            bubbleSort(array);
            writeArrayToFile(array, outputFilename);
            System.out.println("Sorted array written to file: " + outputFilename);

        } else {
            System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();
    }
}