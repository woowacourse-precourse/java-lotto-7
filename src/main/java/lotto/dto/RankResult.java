package lotto.dto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.domain.Won;

public class RankResult {
    private final EnumMap<Rank, Long> ranks;

    public RankResult(List<Rank> ranks) {
        this.ranks = toMap(ranks);
    }

    private static EnumMap<Rank, Long> toMap(List<Rank> ranks) {
        EnumMap<Rank, Long> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, countRank(ranks, rank));
        }
        return result;
    }

    private static long countRank(List<Rank> ranks, Rank rank) {
        return ranks.stream().filter(rank::equals).count();
    }

    public long count(Rank rank) {
        return ranks.get(rank);
    }

    public Won totalProfit() {
        return new Won(sumAllPrice());
    }

    private long sumAllPrice() {
        return this.ranks.entrySet().stream().mapToLong(RankResult::calcProfit).sum();
    }

    private static long calcProfit(Entry<Rank, Long> entry) {
        Rank rank = entry.getKey();
        Long count = entry.getValue();
        return rank.price() * count;
    }
}
