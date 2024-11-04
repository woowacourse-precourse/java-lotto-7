package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.ONE;
import static lotto.constants.LottoConstants.ZERO;

public class LottoResult {

    private final Map<Rank, Long> rankCount;

    public LottoResult() {
        rankCount = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> ZERO));
    }

    public void addRank(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + ONE);
    }

    public Map<Rank, Long> getRankCount() {
        return rankCount;
    }

    public long calculateTotalPrizeMoney() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculateTotalPrize(entry.getValue()))
                .sum();
    }
}
