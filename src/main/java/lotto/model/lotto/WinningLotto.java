package lotto.model.lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final BonusNumber bonusNumber) {
        this.lotto = lotto;
        bonusNumber.validateDuplicated(lotto);
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.lotto.getNumbers()::contains)
                .count();
    }

    public boolean isContainBonus(final Lotto lotto) {
        return lotto.getNumbers().stream()
                .anyMatch(bonusNumber::isEqual);
    }
}
