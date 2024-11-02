package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Result {
    NOTHING(0, 0, false),
    FIFTH(3, 5000, false),
    FORTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean isBonusMatch;

    private static final Map<List<Object>, Result> resultMap = new HashMap<>();

    Result(int matchCount, int prizeMoney, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonusMatch = isBonusMatch;
    }

    static {
        resultMap.put(Arrays.asList(FIRST.matchCount, false), FIRST);
        resultMap.put(Arrays.asList(SECOND.matchCount, SECOND.isBonusMatch), SECOND);
        resultMap.put(Arrays.asList(THIRD.matchCount, THIRD.isBonusMatch), THIRD);
        resultMap.put(Arrays.asList(FORTH.matchCount, false), FORTH);
        resultMap.put(Arrays.asList(FIFTH.matchCount, false), FIFTH);
    }

    public static Result findResult(int matchCount, boolean isBonusMatch) {
        return resultMap.getOrDefault(Arrays.asList(matchCount, isBonusMatch), NOTHING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean getIsBonusMatch() {
        return isBonusMatch;
    }
}
