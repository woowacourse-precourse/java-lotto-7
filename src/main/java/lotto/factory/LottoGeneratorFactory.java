package lotto.factory;

import lotto.service.generator.LottoGenerator;

public class LottoGeneratorFactory {

    public static LottoGenerator create(Integer lottoCount) {
        return new LottoGenerator(lottoCount);
    }
}
