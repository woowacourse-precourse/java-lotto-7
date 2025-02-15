package lotto.model;

import lotto.utils.ExceptionMessage;

public record WinningLotto(Lotto winningLotto, Bonus bonus) {

    public WinningLotto {
        validate(winningLotto, bonus);
    }

    private void validate(Lotto winningNumbers, Bonus bonus) {
        if (winningNumbers.contains(bonus.bonus())) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_DUPLICATED_NUMBER.getMessage());
        }
    }
}
