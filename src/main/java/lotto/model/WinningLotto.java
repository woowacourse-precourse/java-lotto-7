package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS.getMessage());
        }
    }
}
