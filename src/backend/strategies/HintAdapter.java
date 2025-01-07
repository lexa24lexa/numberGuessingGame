package backend.strategies;

public class HintAdapter {
    private HintStrategy hintStrategy;

    // Constructor to set the initial strategy
    public HintAdapter(HintStrategy hintStrategy) {
        this.hintStrategy = hintStrategy;
    }

    // Method to change the hint strategy dynamically
    public void setHintStrategy(HintStrategy newStrategy) {
        this.hintStrategy = newStrategy;
    }

    // Method to get a hint using the current strategy
    public String getHint(int guess, int targetNumber) {
        return hintStrategy.getHint(guess, targetNumber);
    }
}
