package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    final Map<LottoRank, Integer> rankCount;

    public LottoResult(List<LottoRank> lottoRanks) {
        rankCount = new HashMap<>();
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

}
