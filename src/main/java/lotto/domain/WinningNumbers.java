package lotto.domain;

public class WinningNumbers {

    private final Lotto prizeNumber;
    private final int bonusNumber;

    public WinningNumbers(Lotto prizeNumber, int bonusNumber) {
        this.prizeNumber = prizeNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getPrizeNumber() {
        return prizeNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}