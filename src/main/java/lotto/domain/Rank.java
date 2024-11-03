package lotto.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(1, 2_000_000_000L, 6),
    SECOND(2, 30_000_000L, 5),
    THIRD(3, 1_500_000L, 5),
    FOURTH(4, 50_000L, 4),
    FIFTH(5, 5_000L, 3),
    BLANK(6, 0L, -1);

    final Integer rank;
    final Long prize;
    final Integer numberMatched;

    Rank(Integer rank, Long prize, Integer numberMatched) {
        this.rank = rank;
        this.prize = prize;
        this.numberMatched = numberMatched;
    }

    public static Map<Rank, BigInteger> createCounts() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(rank -> rank, rank -> BigInteger.ZERO, (a, b) -> b));
    }

    public Long prize() {
        return prize;
    }

    public Integer numberMatched() {
        return numberMatched;
    }
}
