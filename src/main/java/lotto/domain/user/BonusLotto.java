package lotto.domain.user;

import lotto.domain.Lotto;

public class BonusLotto {
    private final int bonus;

    public BonusLotto(int bonus) {
        this.bonus = bonus;
    }

    public boolean isDuplicateMainLotto(Lotto lotto) {
        return lotto.isContainNumber(bonus);
    }

}
