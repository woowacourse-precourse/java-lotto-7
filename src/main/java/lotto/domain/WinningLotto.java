package lotto.domain;

import java.util.List;
import lotto.exception.BonusNumberDuplicateException;
import lotto.exception.NumberOutOfRangeException;

import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.MAX_NUMBER;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public boolean containsBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getValue() || bonusNumber > MAX_NUMBER.getValue()) {
            throw new NumberOutOfRangeException();
        }
    }

    private void validateBonusNumberDuplication(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
    }
}
