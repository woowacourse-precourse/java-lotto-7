package lotto.Factory;

import lotto.service.BonusGenerator;

public class BonusGeneratorFactory {

    public static BonusGenerator create(String bonus) {
        return new BonusGenerator(bonus);
    }
}
