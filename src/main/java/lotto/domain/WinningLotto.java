package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;

public record WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {

    public WinningLotto {
        validateDuplicatedWithLotto(winningNumbers.numbers(), bonusNumber);
    }

    private static void validateDuplicatedWithLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.bonusNumber())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_DUPLICATED_WITH_LOTTO_NUMBER.getMessage());
        }
    }
}
