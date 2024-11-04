package lotto.draw.model;

public class Draw {
    private final DrawNumbers drawNumbers;
    private final BonusNumber bonusNumber;

    public Draw(final DrawNumbers drawNumbers, final BonusNumber bonusNumber) {
        this.drawNumbers = drawNumbers;
        this.bonusNumber = bonusNumber;
    }

    public DrawNumbers getDrawNumbers() {
        return drawNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
