package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCount;
    private final LottoProfit lottoProfit;

    public LottoResult(List<LottoRank> lottoRanks, int lottoPrice, double totalPrizeMoney) {
        rankCount = new HashMap<>();
        lottoProfit = new LottoProfit(totalPrizeMoney, lottoRanks.size() * lottoPrice);
        initRankCount();
        makeRankCount(lottoRanks);
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

    public LottoProfit getLottoProfit(){
        return lottoProfit;
    }

}
