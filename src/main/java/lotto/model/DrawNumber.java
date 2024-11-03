package lotto.model;

public class DrawNumber {
    private final LottoNumbers drawNumbers;
    private final Integer bonusNumber;

    public DrawNumber(final LottoNumbers drawNumbers, final String bonusNumber) {
        this.drawNumbers = drawNumbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public LottoNumbers getDrawNumbers() {
        return drawNumbers;
    }
}
