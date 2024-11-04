package lotto.model;

import java.util.Map;
import lotto.model.lottowinningstrategy.WinningStrategy;

public class LottoWinningCalculator {

    private final WinningStrategy winningStrategy;

    public LottoWinningCalculator(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public LottoWinningResult calculateWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> lottoRankResult = lottos.calculateLottoRanks(winningStrategy, winningNumbers);
        return new LottoWinningResult(lottoRankResult);
    }
}

