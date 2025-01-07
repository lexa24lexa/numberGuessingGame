package frontend;

public class GameProgress extends Subject {
    private int attemptsLeft;

    public GameProgress(int attempts) {
        this.attemptsLeft = attempts;
    }

    public void makeGuess(int guess, int target) {
        if (guess == target) {
            notifyObservers("Correct! You guessed the number!");
        } else {
            attemptsLeft--;
            notifyObservers("Wrong guess! Attempts left: " + attemptsLeft);
            if (attemptsLeft == 0) {
                notifyObservers("Game Over! The number was: " + target);
            }
        }
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
