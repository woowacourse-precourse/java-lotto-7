package lotto.model.lotto;

import lotto.model.generator.NumberGenerator;
import lotto.model.money.Money;

public class LottosGenerator {
    private final NumberGenerator numberGenerator;

    public LottosGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos getLottos(Money money) {
        return Lottos.of(money, numberGenerator);
    }
}
