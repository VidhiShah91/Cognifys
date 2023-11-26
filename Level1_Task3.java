import java.util.Scanner;

public class Level1_Task3 {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Student Grade Calculator!");

        // Prompt user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        // Validate that the number of grades is positive
        if (numberOfGrades <= 0) {
            System.out.println("Invalid input. Please enter a positive number of grades.");
            // Close the Scanner to prevent resource leak
            scanner.close();
            return;
        }

        // Create an array to store the grades
        double[] grades = new double[numberOfGrades];

        // Prompt user to enter each grade
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Calculate the average grade
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / numberOfGrades;

        // Display the average grade
        System.out.printf("The average grade is: %.2f\n", average);

        // Thank you message
        System.out.println("Thank you for using the Student Grade Calculator!");

        // Close the Scanner to prevent resource leak
        scanner.close();
    }
}
