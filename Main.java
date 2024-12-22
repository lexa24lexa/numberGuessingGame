import backEnd.Factory.*;
import backEnd.Strategies.*;
import frontEnd.GameUI;

import java.util.Scanner;

public class Main {
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

        // Set game parameters based on difficulty
        int maxAttempts = difficulty.equalsIgnoreCase("Easy") ? 10 :
                difficulty.equalsIgnoreCase("Medium") ? 7 : 5;
        int range = difficulty.equalsIgnoreCase("Easy") ? 50 :
                difficulty.equalsIgnoreCase("Medium") ? 100 : 200;

        // Start the game UI
        GameUI gameUI = new GameUI(maxAttempts, range, strategy);
        gameUI.play();
    }
}
