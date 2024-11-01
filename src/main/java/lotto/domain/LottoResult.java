package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCount;
    private final LottoProfit lottoProfit;

    private LottoResult(List<LottoRank> lottoRanks, LottoProfit lottoProfit) {
        this.rankCount = new HashMap<>();
        this.lottoProfit = lottoProfit;
        initRankCount();
        makeRankCount(lottoRanks);
    }

    public static LottoResult ofLottoRanksAndProfit(
            List<LottoRank> lottoRanks, LottoProfit lottoProfit) {
        return new LottoResult(lottoRanks, lottoProfit);
    }

    private void initRankCount() {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> rankCount.put(lottoRank, 0));
    }

    private void makeRankCount(List<LottoRank> lottoRanks) {
        lottoRanks.stream()
                .forEach(lottoRank -> rankCount.put(lottoRank, rankCount.get(lottoRank) + 1));
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCount;
    }

    public LottoProfit getLottoProfit() {
        return lottoProfit;
    }

}
