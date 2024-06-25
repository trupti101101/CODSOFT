/*TASK 1 : NUMBER GAME
1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guessis correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.
You can incorporate additional details as follows:
5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won. */

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input
        Random random = new Random(); // Initialize random number generator
        boolean playAgain = true; // Control variable for the game loop

        while (playAgain) {
            // Define the range for the random number
            int min = 1;
            int max = 100;
            int numberToGuess = random.nextInt(max - min + 1) + min; // Generate random number within the range
            int numberOfAttempts = 0; // Track the number of attempts the user has made
            int maxAttempts = 10; // Define the maximum number of attempts allowed
            boolean hasGuessedCorrectly = false; // Track if the user has guessed the number correctly

            // Introduction message for the user
            System.out.println("\n==Welcome to the Number Guessing Game!==");
            System.out.println("I have selected a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            // Loop for user to make guesses until they run out of attempts or guess correctly
            while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt(); // Read user input
                numberOfAttempts++; // Increment the number of attempts

                // Provide feedback based on the user's guess
                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                    hasGuessedCorrectly = true; // Set flag to true if the guess is correct
                }
            }

            // Message displayed if the user fails to guess the number within the allowed attempts
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            // Ask user if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes"); // Set playAgain to true if user wants to play again
        }

        // Farewell message after the user decides to stop playing
        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close(); // Close the scanner resource
    }
}

