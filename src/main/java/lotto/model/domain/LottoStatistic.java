package lotto.model.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;
import lotto.model.vo.Percent;

public class LottoStatistic {
    private final Map<LottoRank, Integer> lottoRankCount;

    public LottoStatistic(Map<LottoRank, Integer> lottoRankCount) {
        this.lottoRankCount = lottoRankCount;
    }

    public static LottoStatistic of(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> lottoRankCount = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : lottoRanks) {
            Integer count = lottoRankCount.getOrDefault(lottoRank, 0);
            lottoRankCount.put(lottoRank, count + 1);
        }
        return new LottoStatistic(lottoRankCount);
    }

    public Percent getProfitRate() {
        double totalPrize = (double) getTotalPrize();
        long purchaseMoney = getPurchaseMoney();
        return new Percent(totalPrize / purchaseMoney * 100);
    }

    private long getTotalPrize() {
        long totalPrize = 0;
        for (LottoRank lottoRank : lottoRankCount.keySet()) {
            Integer count = lottoRankCount.get(lottoRank);
            totalPrize += ((long) count * lottoRank.getPrize());
        }
        return totalPrize;
    }

    private long getPurchaseMoney() {
        long lottoCount = 0;
        for (LottoRank lottoRank : lottoRankCount.keySet()) {
            lottoCount += lottoRankCount.get(lottoRank);
        }
        return lottoCount * 1000;
    }

    public int getCountByLottoRank(LottoRank lottoRank) {
        return lottoRankCount.getOrDefault(lottoRank, 0);
    }
}
