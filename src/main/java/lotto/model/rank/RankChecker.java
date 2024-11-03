package lotto.model.rank;

import java.util.List;
import lotto.model.lotto.LottoResult;

public class RankChecker {

    public RankResult check(List<LottoResult> results) {
        RankResult rankResult = new RankResult();

        for (LottoResult result : results) {
            addRank(result, rankResult);
        }

        return rankResult;
    }

    private void addRank(LottoResult result, RankResult rankResult) {
        for (Rank rank : Rank.values()) {
            if (isMatchingRank(result, rank)) {
                rankResult.addRank(rank);
                return;
            }
        }
    }

    private boolean isMatchingRank(LottoResult result, Rank rank) {
        return result.getMatchingCount() == rank.getMatchingCount() &&
                rank.isHasBonus() == result.hasBonus();
    }

}
