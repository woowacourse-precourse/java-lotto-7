package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessage;

public class WinningNumbers {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningNumbers(Lotto winningLotto, int bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = BonusNumber.from(bonusNumber);
    }

    public static WinningNumbers of(Lotto winningLotto, int bonusNumber) {
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningLotto.countMatches(lotto);
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return bonusNumber.isMatches(lotto);
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isDuplicateBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_NUMBERS.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusNumber,
                that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
