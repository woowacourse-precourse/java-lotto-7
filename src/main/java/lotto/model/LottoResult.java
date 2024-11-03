package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // 3개 일치
        result.append("3개 일치 (5,000원) - ")
                .append(rankCount.getOrDefault(Rank.FIFTH, 0))
                .append("개\n");

        // 4개 일치
        result.append("4개 일치 (50,000원) - ")
                .append(rankCount.getOrDefault(Rank.FOURTH, 0))
                .append("개\n");

        // 5개 일치
        result.append("5개 일치 (1,500,000원) - ")
                .append(rankCount.getOrDefault(Rank.THIRD, 0))
                .append("개\n");

        // 5개 일치 + 보너스
        result.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(rankCount.getOrDefault(Rank.SECOND, 0))
                .append("개\n");

        // 6개 일치
        result.append("6개 일치 (2,000,000,000원) - ")
                .append(rankCount.getOrDefault(Rank.FIRST, 0))
                .append("개\n");

        return result.toString();
    }


}
