/*Task 2 : Student Grade Calculator
Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user */


import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("\n== Welcome To Student Grade Calculator ==");

        while (continueCalculating) {
            try {
                // Input: Take marks obtained in each subject
                System.out.print("Enter the number of subjects: ");
                int numSubjects = scanner.nextInt();

                if (numSubjects <= 0) {
                    System.out.println("Invalid Input: Number of subjects must be positive.");
                    continue;
                }

                int[] marks = new int[numSubjects];

                for (int i = 0; i < numSubjects; i++) {
                    System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                    int mark = scanner.nextInt();

                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid Input: Marks should be between 0 and 100.");
                        i--; // Retry current subject
                        continue;
                    }

                    marks[i] = mark;
                }

                // Calculate Total Marks
                int totalMarks = 0;
                for (int mark : marks) {
                    totalMarks += mark;
                }

                // Calculate Average Percentage
                double averagePercentage = (double) totalMarks / numSubjects;

                // Grade Calculation
                char grade;
                if (averagePercentage >= 90) {
                    grade = 'A';
                } else if (averagePercentage >= 80) {
                    grade = 'B';
                } else if (averagePercentage >= 70) {
                    grade = 'C';
                } else if (averagePercentage >= 60) {
                    grade = 'D';
                } else {
                    grade = 'F';
                }

                // Display Results
                System.out.println("Total Marks: " + totalMarks);
                System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
                System.out.println("Grade: " + grade);

                // Ask the user if they want to continue
                System.out.print("Do you want to calculate another grade? (yes/no): ");
                scanner.nextLine(); // Consume the newline character
                String response = scanner.nextLine();
                continueCalculating = response.equalsIgnoreCase("yes");

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input: Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        System.out.println("Thank you for using the Student Grade Calculator!");
        scanner.close();
    }
}
