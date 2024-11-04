package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.utils.ErrorMessage;

public class WinningLotto{
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateUniqueBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchWinningNumber(List<Integer> numbers) {
        return lotto.matchNumber(numbers);
    }

    public boolean matchBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    public void validateUniqueBonusNumber(Lotto lotto, int bonusNumber) {
        if (new HashSet<>(lotto.getNumbers()).contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_UNIQUE_NUMBER.getMessage());
        }
    }
}
