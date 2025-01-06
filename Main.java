import backend.Strategies.*;
import backend.Factory.GameFactory;
import frontEnd.GameUI;
import backend.patterns.*;
import frontend.GameUI;
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

        int maxAttempts = difficulty.equalsIgnoreCase("Easy") ? 10 :
                difficulty.equalsIgnoreCase("Medium") ? 7 : 5;
        int range = difficulty.equalsIgnoreCase("Easy") ? 50 :
                difficulty.equalsIgnoreCase("Medium") ? 100 : 200;

        // Select hint type
        System.out.println("Select Hint Type: 1 for Range, 2 for Even/Odd, 3 for High/Low");
        int hintType = scanner.nextInt();
        BonusHint baseHint = (guess, target) -> "Basic Hint";
        BonusHint hintDecorator;

        switch (hintType) {
            case 1:
                hintDecorator = new RangeHintDecorator(baseHint);
                break;
            case 2:
                hintDecorator = new EvenOddHintDecorator(baseHint);
                break;
            case 3:
                hintDecorator = new HighLowHintDecorator(baseHint);
                break;
            default:
                hintDecorator = baseHint;
                break;
        }

        // Start the game UI with chosen settings
        GameUI gameUI = new GameUI(maxAttempts, range, hintDecorator);
        gameUI.play();
    }
}
