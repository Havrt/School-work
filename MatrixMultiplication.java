import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        if (args.length == 2) {
            // Case 1: Two file names provided as command-line arguments
            String file1 = args[0];
            String file2 = args[1];
            int[][] matrix1 = readMatrixFromFile(file1);
            int[][] matrix2 = readMatrixFromFile(file2);

            if (matrix1 != null && matrix2 != null) {
                int[][] result = multiplyMatrices(matrix1, matrix2);
                writeMatrixToFile(result, "matrix3.txt");
                System.out.println("Matrix multiplication result saved to matrix3.txt");
            } else {
                System.out.println("Error reading matrices from files.");
            }
        } else if (args.length == 1) {
            // Case 2: One integer provided as a command-line argument
            try {
                int size = Integer.parseInt(args[0]);
                int[][] matrix1 = generateRandomMatrix(size, size);
                int[][] matrix2 = generateRandomMatrix(size, size);

                writeMatrixToFile(matrix1, "matrix1.txt");
                writeMatrixToFile(matrix2, "matrix2.txt");

                int[][] result = multiplyMatrices(matrix1, matrix2);
                writeMatrixToFile(result, "matrix3.txt");
                System.out.println("Random matrices generated and saved to matrix1.txt and matrix2.txt.");
                System.out.println("Matrix multiplication result saved to matrix3.txt");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide an integer or two file names.");
            }
        } else {
            // Case 3: User input via keyboard
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter two file names or an integer:");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                // User entered an integer
                int size = Integer.parseInt(input);
                int[][] matrix1 = generateRandomMatrix(size, size);
                int[][] matrix2 = generateRandomMatrix(size, size);

                writeMatrixToFile(matrix1, "matrix1.txt");
                writeMatrixToFile(matrix2, "matrix2.txt");

                int[][] result = multiplyMatrices(matrix1, matrix2);
                writeMatrixToFile(result, "matrix3.txt");
                System.out.println("Random matrices generated and saved to matrix1.txt and matrix2.txt.");
                System.out.println("Matrix multiplication result saved to matrix3.txt");
            } else {
                // User entered two file names
                String[] files = input.split("\\s+");
                if (files.length == 2) {
                    int[][] matrix1 = readMatrixFromFile(files[0]);
                    int[][] matrix2 = readMatrixFromFile(files[1]);

                    if (matrix1 != null && matrix2 != null) {
                        int[][] result = multiplyMatrices(matrix1, matrix2);
                        writeMatrixToFile(result, "matrix3.txt");
                        System.out.println("Matrix multiplication result saved to matrix3.txt");
                    } else {
                        System.out.println("Error reading matrices from files.");
                    }
                } else {
                    System.out.println("Invalid input. Please provide two file names or an integer.");
                }
            }
            scanner.close();
        }
    }

    // Read a matrix from a file
    private static int[][] readMatrixFromFile(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            int rows = 0;
            int cols = 0;
            while (fileScanner.hasNextLine()) {
                rows++;
                String line = fileScanner.nextLine();
                cols = line.trim().split("\\s+").length;
            }
            fileScanner.close();

            int[][] matrix = new int[rows][cols];
            fileScanner = new Scanner(new File(fileName));
            for (int i = 0; i < rows; i++) {
                String[] values = fileScanner.nextLine().trim().split("\\s+");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }
            fileScanner.close();
            return matrix;
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            return null;
        }
    }

    // Write a matrix to a file
    private static void writeMatrixToFile(int[][] matrix, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    writer.write(value + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    // Generate a random matrix of given dimensions
    private static int[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // Random values between 0 and 9
            }
        }
        return matrix;
    }

    // Multiply two matrices
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}