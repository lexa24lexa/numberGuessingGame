package backend.Strategies;

public class HigherLowerHint implements HintStrategy {
    @Override
    public String getHint(int guess, int targetNumber) {
        if (guess < targetNumber) {
            return "Higher!";
        } else {
            return "Lower!";
        }
    }
}
