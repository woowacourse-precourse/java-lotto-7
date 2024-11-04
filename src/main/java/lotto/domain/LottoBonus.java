package lotto.domain;

public class LottoBonus {
    private int bonusNumber;

    public LottoBonus() {
        this.bonusNumber = 0;
    }

    public void setLottoBonusNumber(final int lottoBonusNumber) {
        this.bonusNumber = lottoBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
