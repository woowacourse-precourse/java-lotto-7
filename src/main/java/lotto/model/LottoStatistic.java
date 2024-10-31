package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoStatistic {
    private final static int INIT_COUNT = 0;
    private final HashMap<LottoRank, Integer> winningResult = new HashMap<>();
    private double profitRatio;

    public LottoStatistic(List<LottoRank> rankList) {
        initResult();
    }

    public HashMap<LottoRank, Integer> getWinningResult() {
        return new HashMap<>(this.winningResult);
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    private void initResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResult.put(lottoRank, INIT_COUNT);
        }
    }
}
