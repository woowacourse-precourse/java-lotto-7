package lotto.utils;

import java.util.List;

public class LottoNumberGenerator {
    private final LottoNumberGeneratorStrategy strategy;

    private LottoNumberGenerator(LottoNumberGeneratorStrategy strategy) {
        this.strategy = strategy;
    }

    public static LottoNumberGenerator from(LottoNumberGeneratorStrategy strategy) {
        return new LottoNumberGenerator(strategy);
    }

    public List<Integer> generate() {
        return strategy.generate();
    }
}
