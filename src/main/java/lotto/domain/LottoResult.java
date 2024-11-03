package lotto.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final HashMap<LottoRank, Integer> rankCount = new HashMap<>();

    public LottoResult() {
        Arrays.stream(LottoRank.values())
                .forEachOrdered(rank -> rankCount.put(rank, 0));
    }

    public void incrementRankCount(LottoRank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Map.copyOf(rankCount);
    }

    public BigInteger calculateTotalWinnings() {
        return rankCount.entrySet().stream()
                .map(entry -> BigInteger.valueOf(entry.getKey().getPrize())
                                        .multiply(BigInteger.valueOf(entry.getValue())))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}