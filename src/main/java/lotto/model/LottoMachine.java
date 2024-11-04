package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomGenerator;

public class LottoMachine {
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";

    private Integer money;
    private RandomGenerator randomGenerator;

    public LottoMachine(Integer money, RandomGenerator randomGenerator) {
        validate(money);
        this.money = money;
        this.randomGenerator = randomGenerator;
    }

    private void validate(Integer money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
    }

    public List<Lotto> makeLotto() {
        List<Lotto> lottos = new ArrayList<>();
        Integer count = this.money / 1000;

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(randomGenerator.generate());
            lottos.add(lotto);
        }

        return lottos;
    }
}
