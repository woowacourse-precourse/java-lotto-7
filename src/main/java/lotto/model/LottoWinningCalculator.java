package lotto.model;

import java.util.Map;
import lotto.model.lottowinningstrategy.WinningStrategy;

public class LottoWinningCalculator {

    private final WinningStrategy winningStrategy;

    private LottoWinningCalculator(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public static LottoWinningCalculator from(WinningStrategy winningStrategy) {
        return new LottoWinningCalculator(winningStrategy);
    }

    public LottoWinningResult calculateWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> lottoRankResult = lottos.calculateLottoRanks(winningStrategy, winningNumbers);
        return LottoWinningResult.from(lottoRankResult);
    }
}

