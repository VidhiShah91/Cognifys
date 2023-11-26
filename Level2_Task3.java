import java.io.*;
import java.util.Scanner;

public class Level2_Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File Encryption/Decryption!");

        // Prompt the user for encryption or decryption
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char operation = scanner.next().toUpperCase().charAt(0);

        // Prompt the user for the file name or path
        System.out.print("Enter the file name or path: ");
        String fileName = scanner.next();

        // Perform encryption or decryption
        if (operation == 'E') {
            encryptFile(fileName);
            System.out.println("Encryption completed.");
        } else if (operation == 'D') {
            decryptFile(fileName);
            System.out.println("Decryption completed.");
        } else {
            System.out.println("Invalid operation. Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }

    private static void encryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {

            int character;
            while ((character = reader.read()) != -1) {
                // Simple encryption: shift each character by 1
                char encryptedChar = (char) (character + 1);
                writer.write(encryptedChar);
            }

        } catch (IOException e) {
            System.err.println("Error during encryption: " + e.getMessage());
        }
    }

    private static void decryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {

            int character;
            while ((character = reader.read()) != -1) {
                // Simple decryption: shift each character back by 1
                char decryptedChar = (char) (character - 1);
                writer.write(decryptedChar);
            }

        } catch (IOException e) {
            System.err.println("Error during decryption: " + e.getMessage());
        }
    }
}
