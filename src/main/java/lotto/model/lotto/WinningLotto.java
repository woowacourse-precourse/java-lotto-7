package lotto.model.lotto;

import java.util.List;
import lotto.common.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CONFLICT_ERROR.getMessage());
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
