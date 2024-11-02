package lotto.model;

public class LottoDraw {
    private final LottoNumbers drawNumbers;
    private final Integer bonusNumber;

    public LottoDraw(final LottoNumbers drawNumbers, final String bonusNumber) {
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
