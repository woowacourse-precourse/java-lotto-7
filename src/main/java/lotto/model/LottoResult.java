package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.validation.ValidatorImpl.ZERO;

public class LottoResult {
    public static final int ONE = 1;

    private final Map<Rank, Integer> rankCount;

    public LottoResult() {
        rankCount = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> ZERO));
    }

    public void addRank(Rank rank) {
        if (rank != null) {
            rankCount.put(rank, rankCount.get(rank) + ONE);
        }
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public int calculateTotalPrizeMoney() {
        return rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}