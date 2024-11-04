package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Winning {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final long prizeMoney;

    Winning(int matchCount, boolean isBonusNumberMatched, long prizeMoney) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prizeMoney = prizeMoney;
    }

    public static Winning getRank(int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(Winning.values())
                .filter(winning ->
                        (matchCount != SECOND.matchCount() || winning.isBonusNumberMatched == isBonusNumberMatched)
                                && winning.matchCount == matchCount)
                .findFirst()
                .orElse(Winning.NONE);
    }

    public static List<Winning> sortedByMatchCount() {
        return Arrays.stream(Winning.values())
                .sorted(Comparator.comparingInt(Winning::matchCount))
                .toList();
    }

    public int matchCount() {
        return matchCount;
    }

    public boolean isBonusNumberMatched() {
        return isBonusNumberMatched;
    }

    public long prizeMoney() {
        return prizeMoney;
    }
}
