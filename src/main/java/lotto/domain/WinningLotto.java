package lotto.domain;

public class WinningLotto
{
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return (int) this.lotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }
}
