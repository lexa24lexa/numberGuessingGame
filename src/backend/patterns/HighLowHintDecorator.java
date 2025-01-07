package backend.patterns;

public class HighLowHintDecorator implements BonusHint {
    private BonusHint bonusHint;

    public HighLowHintDecorator(BonusHint bonusHint) {
        this.bonusHint = bonusHint;
    }

    @Override
    public String getHint(int guess, int target) {
        String baseHint = bonusHint.getHint(guess, target);
        String highLowHint = guess > target ? "Too high!" : "Too low!";
        return baseHint + " " + highLowHint;
    }
}
