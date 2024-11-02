package lotto.Factory;

import lotto.domain.Bonus;

public class BonusFactory {

    public static Bonus create(Integer bonus) {
        return new Bonus(bonus);
    }
}
