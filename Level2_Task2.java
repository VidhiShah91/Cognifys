import java.util.Scanner;

public class Level2_Task2 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Strength Checker!");
        System.out.print("Please enter your password: ");

        String password = scanner.nextLine();

        // Check password strength
        String strengthFeedback = checkPasswordStrength(password);

        // Display feedback on password strength
        System.out.println("\nPassword Strength: " + strengthFeedback);

        // Thank you message
        System.out.println("\nThank you for using the Password Strength Checker!");

        scanner.close();
    }

    private static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        // Check each character in the password
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (isSpecialCharacter(ch)) {
                hasSpecialChar = true;
            }
        }

        // Analyze password strength based on criteria
        if (length >= 8 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            return "Strong";
        } else if (length >= 6 && (hasUppercase || hasLowercase) && (hasNumber || hasSpecialChar)) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    private static boolean isSpecialCharacter(char ch) {
        // Define a set of special characters
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        return specialCharacters.indexOf(ch) != -1;
    }
}
