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
