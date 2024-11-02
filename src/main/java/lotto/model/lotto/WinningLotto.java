package lotto.model.lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final BonusNumber bonusNumber) {
        this.lotto = lotto;
        validateDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicated(final BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getBonus())) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }

    public int calculateMatchCount(final Lotto lotto) {
        final List<Integer> winningNumbers = this.lotto.getNumbers();
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusMatch(final Lotto lotto) {
        final int bonus = bonusNumber.getBonus();
        return lotto.isContain(bonus);
    }
}
