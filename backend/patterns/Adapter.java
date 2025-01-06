package backend.patterns;

import backend.strategies.HintStrategy;

// New interface to handle different input/output formats
public interface NewHintInterface {
    String generateHint(String guess, String target);
}

// Adapter class implementing the new interface
public class HintAdapter implements NewHintInterface {
    private HintStrategy hintStrategy;

    // Constructor to initialize with a specific strategy
    public HintAdapter(HintStrategy hintStrategy) {
        this.hintStrategy = hintStrategy;
    }

    // Adapts the input and output to match the new interface
    @Override
    public String generateHint(String guess, String target) {
        try {
            int guessNum = Integer.parseInt(guess);
            int targetNum = Integer.parseInt(target);
            return hintStrategy.getHint(guessNum, targetNum);
        } catch (NumberFormatException e) {
            return "Invalid input format. Please enter valid numbers.";
        }
    }

    // Allows dynamic switching of strategies
    public void setHintStrategy(HintStrategy hintStrategy) {
        this.hintStrategy = hintStrategy;
    }
}
