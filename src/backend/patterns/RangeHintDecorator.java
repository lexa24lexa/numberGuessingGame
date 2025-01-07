package backend.patterns;

public class RangeHintDecorator implements BonusHint {
    private BonusHint bonusHint;

    public RangeHintDecorator(BonusHint bonusHint) {
        this.bonusHint = bonusHint;
    }

    @Override
    public String getHint(int guess, int target) {
        String baseHint = bonusHint.getHint(guess, target);
        int range = Math.abs(guess - target);
        String rangeHint = range > 10 ? "You are far away!" : "You are very close!";
        return baseHint + " " + rangeHint;
    }
}
