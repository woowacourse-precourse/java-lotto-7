package lotto.factory;

import lotto.domain.Lotto;
import lotto.service.BonusGenerator;

public class BonusGeneratorFactory {

    public static BonusGenerator create(Lotto winning, String bonus) {
        return new BonusGenerator(winning, bonus);
    }
}
