package backend.patterns;

public class EvenOddHintDecorator implements BonusHint {
    private BonusHint bonusHint;

    public EvenOddHintDecorator(BonusHint bonusHint) {
        this.bonusHint = bonusHint;
    }

    @Override
    public String getHint(int guess, int target) {
        String baseHint = bonusHint.getHint(guess, target);
        String evenOddHint = (guess % 2 == target % 2) ? "Same parity!" : "Different parity!";
        return baseHint + " " + evenOddHint;
    }
}
