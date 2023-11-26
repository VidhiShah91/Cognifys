import java.util.Scanner;

public class Level1_Task1{
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Temperature Converter!");

        // Prompt user to enter temperature value
        System.out.print("Enter temperature value: ");
        
        // Validate input to ensure a valid double is entered
        double temperature = 0;
        try {
            temperature = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numeric value for temperature.");
            System.exit(1); // Exit the program
        }

        // Prompt user to enter unit of measurement
        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);

        // Perform the conversion based on the entered unit
        double convertedTemperature;
        if (unit == 'F' || unit == 'f') {
            // Convert Celsius to Fahrenheit
            convertedTemperature = (temperature * 9 / 5) + 32;
            System.out.println("Converted temperature in Fahrenheit: " + convertedTemperature + " F");
        } else if (unit == 'C' || unit == 'c') {
            // Convert Fahrenheit to Celsius
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.println("Converted temperature in Celsius: " + convertedTemperature + " C");
        } else {
            // Invalid input for unit
            System.out.println("Invalid unit of measurement. Please enter 'C' or 'F'.");
        }

        // Thank you message
        System.out.println("Thank you for using the Temperature Converter!");

        // Close the Scanner to prevent resource leak
        scanner.close();
    }
}
