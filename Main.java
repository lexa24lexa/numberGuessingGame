import backend.patterns.*;
import backend.strategies.*;
import backend.factory.GameFactory;
import backend.game.Game;
import frontend.GameUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select difficulty and create a game instance via Factory
        System.out.println("Select Difficulty: Easy, Medium, or Hard");
        String difficulty = scanner.nextLine();

        // Use the factory to create a Game instance
        Game game = GameFactory.createGame(difficulty);
        game.start(); // Outputs game-specific configuration (e.g., attempts and range)

        // Set parameters based on the selected difficulty
        int maxAttempts = difficulty.equalsIgnoreCase("Easy") ? 10 :
                difficulty.equalsIgnoreCase("Medium") ? 7 : 5;
        int range = difficulty.equalsIgnoreCase("Easy") ? 50 :
                difficulty.equalsIgnoreCase("Medium") ? 100 : 200;

        // Select hint strategy
        System.out.println("Select Hint Strategy: 1 for Higher/Lower, 2 for Hot/Cold");
        int strategyChoice = scanner.nextInt();
        HintStrategy strategy = strategyChoice == 1 ? new HigherLowerHint() : new HotColdHint();

        // Use HintAdapter with the selected strategy
        HintAdapter hintAdapter = new HintAdapter(strategy);

        // Select decorator for bonus hints
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

        // Initialize the GameUI with selected parameters
        GameUI gameUI = new GameUI(maxAttempts, range, hintDecorator);
        gameUI.play();

        scanner.close();
    }
}
