package lotto.model.draw;

public class Draw {
    private final DrawNumbers drawNumbers;
    private final Integer bonusNumber;

    public Draw(final DrawNumbers drawNumbers, final String bonusNumber) {
        this.drawNumbers = drawNumbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public DrawNumbers getDrawNumbers() {
        return drawNumbers;
    }
}
