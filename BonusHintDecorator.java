package backend.patterns;

// Interface for Bonus Hint Decorator
public interface BonusHint {
    String getHint(int guess, int target);
}

// Base Hint Decorator implementing BonusHint
public class BaseHintDecorator implements BonusHint {
    private BonusHint bonusHint;

    // Constructor
    public BaseHintDecorator(BonusHint bonusHint) {
        this.bonusHint = bonusHint;
    }

    // Pass-through implementation
    @Override
    public String getHint(int guess, int target) {
        return bonusHint.getHint(guess, target);
    }
}