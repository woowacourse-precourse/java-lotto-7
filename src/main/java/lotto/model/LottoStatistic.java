package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class LottoStatistic {
    private final static int INIT_COUNT = 0;
    private final HashMap<LottoRank, Integer> winningResult = new HashMap<>();
    private double profitRatio;

    public LottoStatistic(List<LottoRank> rankList) {
        initResult();
        calculateResult(rankList);
        calculateProfitRatio();
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

    private void calculateResult(List<LottoRank> rankList) {
        for (LottoRank lottoRank : rankList) {
            winningResult.put(lottoRank, winningResult.getOrDefault(lottoRank, INIT_COUNT) + 1);
        }
    }

    private void calculateProfitRatio() {
        double totalPrizeMoney = 0;
        double totalLottoTimes = 0;

        for (Entry<LottoRank, Integer> lottoRankIntegerEntry : winningResult.entrySet()) {
            Integer winCount = lottoRankIntegerEntry.getValue();
            int prizeMoney = lottoRankIntegerEntry.getKey().prizeMoney;

            totalLottoTimes += winCount;
            totalPrizeMoney += prizeMoney * winCount;
        }

        this.profitRatio = totalPrizeMoney / (totalLottoTimes * 1000) * 100;
    }
}
