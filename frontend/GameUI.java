import java.util.Scanner;
import frontend.ObserverPattern.*;
import backend.patterns.Singleton;

public class GameUI {
    private Scanner scanner;
    private int targetNumber;
    private int attemptsLeft;
    private GameProgress gameProgress;

    // Constructor
    public GameUI(int maxAttempts, int range) {
        scanner = new Scanner(System.in);
        Singleton rng = Singleton.getInstance();
        targetNumber = rng.generate(1, range);
        attemptsLeft = maxAttempts;
        gameProgress = new GameProgress(maxAttempts);
        gameProgress.addObserver(new ConsoleObserver());
    }

    // Main game loop
    public void play() {
        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number. Good luck!");
        while (attemptsLeft > 0) {
            System.out.print("\nEnter your guess: ");
            int guess = getUserInput();
            gameProgress.makeGuess(guess, targetNumber);
            if (guess == targetNumber) {
                System.out.println("🎉 Congratulations! You guessed the number!");
                break;
            } else {
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
            if (attemptsLeft == 0) {
                System.out.println("💥 Game Over! The number was: " + targetNumber);
            }
        }
    }

    // Input validation
    private int getUserInput() {
        int guess = -1;
        while (true) {
            try {
                guess = Integer.parseInt(scanner.nextLine());
                if (guess > 0) break;
                else System.out.print("Invalid input! Enter a positive number: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
        return guess;
    }

    // Main method to start the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select difficulty
        System.out.println("Select Difficulty: Easy, Medium, or Hard");
        String difficulty = scanner.nextLine();

        int maxAttempts = difficulty.equalsIgnoreCase("Easy") ? 10 :
                difficulty.equalsIgnoreCase("Medium") ? 7 : 5;
        int range = difficulty.equalsIgnoreCase("Easy") ? 50 :
                difficulty.equalsIgnoreCase("Medium") ? 100 : 200;

        GameUI gameUI = new GameUI(maxAttempts, range);
        gameUI.play();
    }
}
