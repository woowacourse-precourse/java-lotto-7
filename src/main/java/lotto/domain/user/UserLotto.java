package lotto.domain.user;

import lotto.domain.Lotto;

public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLottos bonusLotto;

    public UserLotto(BonusLottos bonusLotto, Lotto mainLotto) {
        this.bonusLotto = bonusLotto;
        this.mainLotto = mainLotto;
    }
}
