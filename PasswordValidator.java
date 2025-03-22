import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    public static boolean isValidPassword(String password) {
        // Check length requirement
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Flags to track the presence of each category
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;

        // Define the set of special symbols
        String specialSymbols = "~!@#$%^&*()-=+_";

        // Iterate through each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (specialSymbols.contains(String.valueOf(ch))) {
                hasSpecial = true;
            }
        }

        // Count how many categories are present
        int categoryCount = 0;
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;

        // Check if at least three categories are present
        return categoryCount >= 3;
    }
}