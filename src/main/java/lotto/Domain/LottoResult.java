package lotto.Domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Enum.LottoPrizeRank;

public class LottoResult {
    private final Map<LottoPrizeRank, Integer> results;

    public LottoResult() {
        results = Arrays.stream(LottoPrizeRank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 0,
                        (a, b) -> b,
                        () -> new EnumMap<>(LottoPrizeRank.class)
                ));
    }

    public void addResult(LottoPrizeRank rank) {
        results.merge(rank, 1, Integer::sum);
    }

    public int getCount(LottoPrizeRank rank) {
        return results.getOrDefault(rank, 0);
    }
}