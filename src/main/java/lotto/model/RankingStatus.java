package lotto.model;

import java.util.EnumMap;

public class RankingStatus {
    private final EnumMap<Ranking, Integer> rankingStatus;

    public RankingStatus() {
        rankingStatus = new EnumMap<>(Ranking.class);

        for (Ranking value : Ranking.values()) {
            rankingStatus.put(value, 0);
        }
    }

    public void updateRankStatus(Ranking ranking) {
        rankingStatus.put(ranking, rankingStatus.get(ranking) + 1);
    }

    public long getTotalPrize() {
        long totalPrize = 0;

        for (Ranking ranking : Ranking.values()) {
            Integer winningCount = rankingStatus.get(ranking);

            totalPrize += ranking.getPrizeMoney(winningCount);
        }

        return totalPrize;
    }
}
