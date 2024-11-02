package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return lotto.getNumbers().contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }
}
