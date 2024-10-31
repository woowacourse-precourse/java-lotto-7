package lotto.model;

import lotto.utils.ExceptionMessage;

public class WinningLotto {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto winningNumbers, Bonus bonus) {
        if (winningNumbers.contains(bonus.bonus())) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_DUPLICATED_NUMBER.getMessage());
        }
    }


}
