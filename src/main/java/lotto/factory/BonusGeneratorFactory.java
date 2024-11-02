package lotto.factory;

import lotto.domain.Lotto;
import lotto.service.generator.BonusGenerator;

public class BonusGeneratorFactory {

    public static BonusGenerator create(Lotto winning, String bonus) {
        return new BonusGenerator(winning, bonus);
    }
}
