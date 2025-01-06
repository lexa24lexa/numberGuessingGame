package backend.Factory;

import backend.Game.Game;
import backend.Game.EasyGame;
import backend.Game.MediumGame;
import backend.Game.HardGame;

public class GameFactory {

    // Factory Method to create a game instance based on difficulty
    public static Game createGame(String difficulty) {
        if (difficulty == null) {
            throw new IllegalArgumentException("Difficulty level cannot be null");
        }

        switch (difficulty.toLowerCase()) {
            case "easy":
                return new EasyGame();
            case "medium":
                return new MediumGame();
            case "hard":
                return new HardGame();
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficulty);
        }
    }
}

// Define the base Game class and its concrete implementations
package backend.Game;

public abstract class Game {
    public abstract void start();
}

package backend.Game;

public class EasyGame extends Game {
    @Override
    public void start() {
        System.out.println("Starting an Easy Game with 10 attempts and a range of 1-50.");
    }
}

package backend.Game;

public class MediumGame extends Game {
    @Override
    public void start() {
        System.out.println("Starting a Medium Game with 7 attempts and a range of 1-100.");
    }
}

package backend.Game;

public class HardGame extends Game {
    @Override
    public void start() {
        System.out.println("Starting a Hard Game with 5 attempts and a range of 1-200.");
    }
}
