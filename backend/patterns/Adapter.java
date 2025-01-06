package backend.Patterns;

import backend.Strategies.HintStrategy;

public class Adapter {
    // This class can act as an additional interface or utility for adapting strategies
    // Currently, HintAdapter is handling the primary adapter logic
    // If further functionality or adaptations are needed, you can extend this class

    public static String adaptHint(HintStrategy strategy, int guess, int targetNumber) {
        // For now, delegate directly to the strategy
        return strategy.provideHint(guess, targetNumber);
    }
}

// Example usage:
// Adapter.adaptHint(new HigherLowerHint(), 30, 50);
