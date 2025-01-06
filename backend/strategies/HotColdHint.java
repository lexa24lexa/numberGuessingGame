package backend.Strategies;

public class HotColdHint implements HintStrategy {
    @Override
    public String getHint(int guess, int targetNumber) {
        int difference = Math.abs(targetNumber - guess);
        if (difference == 0) {
            return "Correct!";
        } else if (difference <= 5) {
            return "Very Hot!";
        } else if (difference <= 10) {
            return "Hot!";
        } else if (difference <= 20) {
            return "Warm!";
        } else {
            return "Cold!";
        }
    }
}
