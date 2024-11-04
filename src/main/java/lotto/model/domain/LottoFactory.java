package lotto.model.domain;

import lotto.util.RandomLottoNumberGenerator;

public class LottoFactory {

    private static final LottoFactory INSTANCE = new LottoFactory();

    private LottoFactory() {

    }

    public static LottoFactory getInstance() {
        return INSTANCE;
    }

    public Lotto createLotto() {
        return new Lotto(RandomLottoNumberGenerator.pickUnique6Numbers());
    }
}
