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
        appendRank(result, Rank.FIFTH, "3개 일치 (5,000원)");
        appendRank(result, Rank.FOURTH, "4개 일치 (50,000원)");
        appendRank(result, Rank.THIRD, "5개 일치 (1,500,000원)");
        appendRank(result, Rank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        appendRank(result, Rank.FIRST, "6개 일치 (2,000,000,000원)");
        return result.toString();
    }

    private void appendRank(StringBuilder result, Rank rank, String description) {
        result.append(description)
                .append(" - ")
                .append(rankCount.getOrDefault(rank, 0))
                .append("개\n");
    }



}
