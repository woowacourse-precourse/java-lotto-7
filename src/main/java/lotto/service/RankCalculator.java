package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
            Rank rank = determinRank(lotto, winningResult);
            if(rank != null) rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    private Rank determinRank(Lotto lotto, LottoResult winningResult) {
        int matchCount = lotto.matchNumber(new Lotto(winningResult
                .getWinningNumbers().stream().sorted()
                .collect(Collectors.toList())));
        boolean bonusMatch = lotto.containsNumber(winningResult.getBonusNumber());

        switch (matchCount){
            case 6:
                return Rank.FIRST;
            case 5:
                return bonusMatch ? Rank.SECOND : Rank.THIRD;
            case 4:
                return Rank.FOURTH;
            case 3:
                return Rank.FIFTH;
            default:
                return null;
        }
    }
}
