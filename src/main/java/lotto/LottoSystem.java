package lotto;

import lotto.constant.ErrorMessage;

public class LottoSystem {
    private final Lotto lotto;
    private final Bonus bonus;

    public LottoSystem(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
