package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessage;

public record WinningLotto(Lotto lotto, int bonusNumber) {

    public WinningLotto {
        validateDuplicateBonusNumber(lotto.getNumbers(), bonusNumber);
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }
}