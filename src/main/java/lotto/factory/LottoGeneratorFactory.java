package lotto.factory;

import lotto.service.LottoGenerator;

public class LottoGeneratorFactory {

    public static LottoGenerator create(Integer lottoCount) {
        return new LottoGenerator(lottoCount);
    }
}
