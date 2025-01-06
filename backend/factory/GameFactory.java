package backend.factory;

import backend.game.Game;
import backend.game.EasyGame;
import backend.game.MediumGame;
import backend.game.HardGame;

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
