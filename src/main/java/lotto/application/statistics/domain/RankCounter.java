package lotto.application.statistics.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class RankCounter {
    private final Map<Rank, Long> counter;

    public RankCounter() {
        this.counter = new EnumMap<>(Rank.class);
        initialize();
    }

    public int calculateTotalPrize() {
        return counter.entrySet().stream()
                .mapToInt(entry -> multiplyPrize(entry.getKey(), entry.getValue()))
                .sum();
    }

    public void add(Rank rank) {
        counter.put(rank, counter.get(rank) + 1);
    }

    public long getCount(Rank rank) {
        return counter.get(rank);
    }

    private void initialize() {
        Arrays.stream(Rank.values())
                .forEach(rank -> counter.put(rank, 0L));
    }

    private int multiplyPrize(Rank rank, Long count) {
        return (int) (rank.getPrize() * count);
    }

}
