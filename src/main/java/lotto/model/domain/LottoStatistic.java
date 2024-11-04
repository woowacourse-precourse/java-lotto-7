package lotto.model.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

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

    public int getCountByLottoRank(LottoRank lottoRank) {
        return lottoRankCount.getOrDefault(lottoRank, 0);
    }
}
