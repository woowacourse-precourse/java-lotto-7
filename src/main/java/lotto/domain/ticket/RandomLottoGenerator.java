package lotto.domain.ticket;

import lotto.utils.UniqueNumberGenerator;

public class RandomLottoGenerator implements LottoGenerator {
    private static final UniqueNumberGenerator UNIQUE_NUMBER_GENERATOR = new UniqueNumberGenerator(LottoNumber.MIN, LottoNumber.MAX);
    private static final int LENGTH = 6;
    private static final RandomLottoGenerator INSTANCE = new RandomLottoGenerator();

    private RandomLottoGenerator() {
    }

    public static RandomLottoGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public Lotto generate() {
        return new Lotto(UNIQUE_NUMBER_GENERATOR.generate(LENGTH));
    }
}
