package lotto.domain;

import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberRangeException;

public class BonusNumber {
    private final int number;

    private BonusNumber(WinningLotto winningLotto, int number) {
        validateRange(number);
        validateDuplicate(winningLotto, number);
        this.number = number;
    }

    public static BonusNumber of(WinningLotto winningLotto, int number) {
        return new BonusNumber(winningLotto, number);
    }

    private void validateRange(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new LottoNumberRangeException();
        }
    }

    private void validateDuplicate(WinningLotto winningLotto, int number) {
        if (winningLotto.isContain(number)) {
            throw new LottoNumberDuplicateException();
        }
    }

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.isContain(number);
    }
}
