package lotto.domain.lottos.user;

import lotto.domain.lottos.Lotto;

public class BonusLotto {
    private final int bonus;

    public BonusLotto(int bonus) {
        this.bonus = bonus;
    }

    public boolean isContainedMainLotto(Lotto lotto) {
        return lotto.isContainNumber(bonus);
    }
    

    @Override
    public String toString() {
        return bonus + "";
    }

}
