package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseCalculator;
import lotto.util.RandomNumberGenerator;

class LottoManager {
    private final LottoPurchaseCalculator lottoCalculator;

    public LottoManager(RandomNumberGenerator randomNumberGenerator) {
        this.lottoCalculator = new LottoPurchaseCalculator(randomNumberGenerator);
    }

    public int getLottoCount(String price) {
        return lottoCalculator.getLottoCount(price);
    }

    public List<Lotto> generateLottoNumbers(int count) {
        return lottoCalculator.generateLottoNumbers(count);
    }
}
