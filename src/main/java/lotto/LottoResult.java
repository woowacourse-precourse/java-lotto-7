package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private double rateReturn;
    private Map<LottoRank, Integer> rankCountMap;

    public LottoResult() {
        Map<LottoRank, Integer> rankCountMap = new HashMap<>();
        rankCountMap.putIfAbsent(LottoRank.FIRST, 0);
        rankCountMap.putIfAbsent(LottoRank.SECOND, 0);
        rankCountMap.putIfAbsent(LottoRank.THIRD, 0);
        rankCountMap.putIfAbsent(LottoRank.FOURTH, 0);
        rankCountMap.putIfAbsent(LottoRank.FIFTH, 0);

        this.rateReturn = 0.0;
        this.rankCountMap = rankCountMap;
    }

    public double getRateReturn() {
        return rateReturn;
    }

    public Map<LottoRank, Integer> getRankCountMap() {
        return rankCountMap;
    }

    public void setRateReturn(double rateReturn) {
        this.rateReturn = rateReturn;
    }
}
