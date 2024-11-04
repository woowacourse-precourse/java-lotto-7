package lotto.domain;

import java.util.Comparator;
import java.util.TreeMap;
import lotto.enums.Rank;

public class LottoResult {
    private final TreeMap<Rank, Integer> rankResults;

    public LottoResult() {
        rankResults = new TreeMap<>(Comparator.comparingInt(Enum::ordinal));
        for (Rank rank : Rank.values()) {
            if (!rank.equals(Rank.ZERO)) {
                rankResults.put(rank, 0);
            }
        }
    }

    public void addResult(Rank rank) {
        if (!rank.equals(Rank.ZERO)) {
            rankResults.compute(rank, (k, v) -> v + 1);
        }
    }

    public TreeMap<Rank, Integer> getRankResults() {
        return rankResults;
    }
}
