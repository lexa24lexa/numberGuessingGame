import backEnd.Factory.*;
import backEnd.Strategies.*;
import backEnd.patterns.*;
import frontEnd.GameUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select difficulty
        System.out.println("Select Difficulty: Easy, Medium, or Hard");
        String difficulty = scanner.nextLine();

        // Set game parameters based on difficulty
        int maxAttempts;
        int range;
        if (difficulty.equalsIgnoreCase("Easy")) {
            maxAttempts = 10;
            range = 50;
        } else if (difficulty.equalsIgnoreCase("Medium")) {
            maxAttempts = 7;
            range = 100;
        } else {
            maxAttempts = 5;
            range = 200;
        }

        // Select hint strategy
        System.out.println("Select Hint Strategy: 1 for Higher/Lower, 2 for Hot/Cold");
        int strategyChoice = scanner.nextInt();
        HintStrategy strategy = strategyChoice == 1 ? new HigherLowerHint() : new HotColdHint();

        // Initialize HintAdapter with the selected strategy
        HintAdapter hintAdapter = new HintAdapter(strategy);

        // Generate target number
        int targetNumber = (int) (Math.random() * range) + 1;
        int attemptsLeft = maxAttempts;

        // Game instructions
        System.out.println("\uD83C\uDFAE Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number. You have " + attemptsLeft + " attempts. Good luck!");

        // Main game loop
        while (attemptsLeft > 0) {
            System.out.print("\nEnter your guess: ");
            int guess = scanner.nextInt();

            // Check the guess
            if (guess == targetNumber) {
                System.out.println("\uD83C\uDF89 Congratulations! You guessed the number!");
                break;
            } else {
                attemptsLeft--;
                System.out.println(hintAdapter.getHint(guess, targetNumber));
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (attemptsLeft == 0) {
                System.out.println("\uD83D\uDCA5 Game Over! The number was: " + targetNumber);
            }
        }

        scanner.close();
    }
}
