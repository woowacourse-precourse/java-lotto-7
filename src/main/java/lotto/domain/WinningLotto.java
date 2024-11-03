package lotto.domain;

import java.util.List;
import lotto.util.ExceptionMessages;

public class WinningLotto {
    private final Lotto lotto;
    private final List<Integer> numbers;
    private final int bonusNumber;

    private WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.numbers = lotto.getNumbers();
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(final Lotto lotto, final int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ExceptionMessages.EXTEND_NUMBERS_BOUNDARY.getMessage());
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
