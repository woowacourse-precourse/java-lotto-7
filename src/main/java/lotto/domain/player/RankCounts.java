package lotto.domain.player;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.constant.Rank;

public class RankCounts {

    private static final int COUNT_INCREASE_UNIT = 1;

    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public void add(Rank rank) {
        rankCounts.merge(rank, COUNT_INCREASE_UNIT, Integer::sum);
    }

    public long totalPrice() {
        return rankCounts.entrySet().stream()
            .mapToLong(set -> {
                Rank rank = set.getKey();
                int count = set.getValue();
                return rank.getPrice() * count;
            })
            .sum();
    }

    public List<RankCount> getAll() {
        return rankCounts.entrySet().stream()
            .map(set -> new RankCount(set.getKey(), set.getValue()))
            .toList();
    }

    public record RankCount(
        Rank rank,
        int count
    ) {
    }
}
