import java.util.Scanner;
import java.security.SecureRandom;

public class Level1_Task4 
{
    public static void main(String[] args) 
    {
        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Random Password Generator!");

        // Prompt user to enter the desired length of the password
        System.out.print("Enter the desired length of the password: ");
        int passwordLength = scanner.nextInt();

        // Validate that the password length is positive
        if (passwordLength <= 0) 
	{
            System.out.println("Invalid input. Please enter a positive password length.");
            // Close the Scanner to prevent resource leak
            scanner.close();
            return;
        }

        // Prompt user for password criteria
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("yes");

        // Generate the random password
        String password = generateRandomPassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialCharacters);

        // Display the generated password in a stylish way
        System.out.println("\nYour randomly generated password is:");
        System.out.println("************************************");
        System.out.println("*                                  *");
        System.out.println("*          " + password + "                          *");
        System.out.println("*                                  *");
        System.out.println("************************************");

        // Thank you message
        System.out.println("\nThank you for using the Random Password Generator!");

        // Close the Scanner to prevent resource leak
        scanner.close();
    }

    // Function to generate a random password based on user criteria
    private static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean    includeSpecialCharacters) 
	{
        StringBuilder password = new StringBuilder();
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        String allChars = "";

        if (includeLowercase) {
            allChars += lowercaseChars;
        }

        if (includeUppercase) {
            allChars += uppercaseChars;
        }

        if (includeNumbers) {
            allChars += numberChars;
        }

        if (includeSpecialCharacters) {
            allChars += specialChars;
        }

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) 
	{
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
