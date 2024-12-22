import java.util.Scanner;
import backEnd.Utils.RandomNumberGenerator;
import backEnd.Strategies.*;
import backEnd.Factory.*;
import frontEnd.ObserverPattern.*;

public class GameUI {
    private Scanner scanner;
    private int targetNumber;
    private HintAdapter hintAdapter;
    private GameProgress gameProgress;

    // Constructor
    public GameUI(int maxAttempts, int range, HintStrategy strategy) {
        scanner = new Scanner(System.in);
        RandomNumberGenerator rng = RandomNumberGenerator.getInstance();
        targetNumber = rng.generate(1, range);
        hintAdapter = new HintAdapter(strategy);

        // Inicializa GameProgress com Observador
        gameProgress = new GameProgress(maxAttempts);
        gameProgress.addObserver(new ConsoleObserver());
    }

    // Main game loop
    public void play() {
        System.out.println("\ud83c\udfae Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number. Good luck!");

        while (gameProgress.getAttemptsLeft() > 0) {
            System.out.print("\nEnter your guess: ");
            int guess = getUserInput();

            gameProgress.makeGuess(guess, targetNumber);

            if (guess != targetNumber) {
                System.out.println(hintAdapter.getHint(guess, targetNumber));
            }

            if (gameProgress.getAttemptsLeft() == 0) {
                System.out.println("\ud83d\udca5 Game Over! The number was: " + targetNumber);
            }

            if (guess == targetNumber) {
                break;
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

        Game game = GameFactory.createGame(difficulty);
        game.start();

        // Select hint strategy
        System.out.println("Select Hint Strategy: 1 for Higher/Lower, 2 for Hot/Cold");
        int strategyChoice = scanner.nextInt();
        HintStrategy strategy = strategyChoice == 1 ? new HigherLowerHint() : new HotColdHint();

        // Start the UI with selected settings
        int maxAttempts = difficulty.equalsIgnoreCase("Easy") ? 10 :
                difficulty.equalsIgnoreCase("Medium") ? 7 : 5;
        int range = difficulty.equalsIgnoreCase("Easy") ? 50 :
                difficulty.equalsIgnoreCase("Medium") ? 100 : 200;

        GameUI gameUI = new GameUI(maxAttempts, range, strategy);
        gameUI.play();
    }
}
