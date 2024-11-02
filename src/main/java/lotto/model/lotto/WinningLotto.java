package lotto.model.lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final BonusNumber bonusNumber) {
        this.lotto = lotto;
        validateDuplicated(bonusNumber);
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

    private void validateDuplicated(final BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getBonus())) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }
}
