package frontend;

import frontend.ConsoleObserver;
import frontend.GameProgress;
import backend.patterns.Singleton;
import backend.patterns.BonusHint;
import backend.patterns.RangeHintDecorator;
import backend.patterns.EvenOddHintDecorator;
import backend.patterns.HighLowHintDecorator;

import java.util.Scanner;

public class GameUI {
    private Scanner scanner;
    private int targetNumber;
    private int attemptsLeft;
    private GameProgress gameProgress;
    private BonusHint hintDecorator;

    // Constructor
    public GameUI(int maxAttempts, int range, BonusHint hintDecorator) {
        scanner = new Scanner(System.in);
        Singleton rng = Singleton.getInstance();
        targetNumber = rng.generate(1, range);
        attemptsLeft = maxAttempts;
        gameProgress = new GameProgress(maxAttempts);
        gameProgress.addObserver(new ConsoleObserver());
        this.hintDecorator = hintDecorator;
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
                System.out.println("Hint: " + hintDecorator.getHint(guess, targetNumber));
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
}
