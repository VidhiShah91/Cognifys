import java.util.Scanner;

public class Level1_Task2 {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Palindrome Checker!");

        // Prompt user to enter a word or phrase
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        // Check if the input is a palindrome
        if (isPalindrome(input)) {
            System.out.println("'" + input + "' is a palindrome!");
        } else {
            System.out.println("'" + input + "' is not a palindrome.");
        }

        // Thank you message
        System.out.println("Thank you for using the Palindrome Checker!");

        // Close the Scanner to prevent resource leak
        scanner.close();
    }

    // Function to check if a string is a palindrome
    private static boolean isPalindrome(String input) {
        // Remove spaces and convert to lowercase
        String cleanInput = input.replaceAll("\\s", "").toLowerCase();

        // Compare the original and reversed strings
        String reversedInput = new StringBuilder(cleanInput).reverse().toString();
        return cleanInput.equals(reversedInput);
    }
}
