package lotto.dto;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;

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
}
