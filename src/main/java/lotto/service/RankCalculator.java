package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class RankCalculator {
    public Map<Rank, Integer> calculateRanks(List<Lotto> userLottos, LottoResult winningResult){
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank: Rank.values()){
            rankCount.put(rank, 0);
        }
        for(Lotto lotto: userLottos){
            Rank rank = determineRank(lotto, winningResult);
            if(rank != null) rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    private Rank determineRank(Lotto lotto, LottoResult winningResult) {
        int matchCount = lotto.matchNumber(winningResult.getWinningNumbers());
        boolean bonusMatch = lotto.containsNumber(winningResult.getBonusNumber());

        return Rank.from(matchCount, bonusMatch);
    }
}
