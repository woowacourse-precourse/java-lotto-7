package lotto.domain;

import lotto.Lotto;

public class LottoMachine {
    private final NumberGenerater numberGenerater = new NumberGenerater(6);

    private Lotto generateLotto() {
        return new Lotto(numberGenerater.createRandomNumbers());
    }
}
