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

// Concrete Decorator for providing bonus hints
public class RangeHintDecorator extends BaseHintDecorator {
    public RangeHintDecorator(BonusHint bonusHint) {
        super(bonusHint);
    }

    @Override
    public String getHint(int guess, int target) {
        String baseHint = super.getHint(guess, target);
        int range = Math.abs(guess - target);
        String rangeHint = range > 10 ? "You are far away!" : "You are very close!";
        return baseHint + " " + rangeHint;
    }
}

// Additional Decorator for even/odd hints
public class EvenOddHintDecorator extends BaseHintDecorator {
    public EvenOddHintDecorator(BonusHint bonusHint) {
        super(bonusHint);
    }

    @Override
    public String getHint(int guess, int target) {
        String baseHint = super.getHint(guess, target);
        String evenOddHint = (guess % 2 == target % 2) ? "Same parity!" : "Different parity!";
        return baseHint + " " + evenOddHint;
    }
}