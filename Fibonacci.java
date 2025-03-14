public class Fibonacci {
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }

        // Parse the command-line argument as an integer
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide a valid integer.");
            return;
        }

        // Ensure the input is non-negative
        if (n < 0) {
            System.out.println("Please provide a non-negative integer.");
            return;
        }

        // Compute and print the Fibonacci number
        long result = computeFibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }

    // Method to compute the Fibonacci number using recursion
    public static long computeFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return computeFibonacci(n - 1) + computeFibonacci(n - 2);
        }
    }
}