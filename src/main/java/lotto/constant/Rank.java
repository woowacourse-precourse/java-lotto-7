package lotto.constant;

import java.util.Map;

public enum Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000),
    NO_MATCH(0, 0);

    private static final Map<String, Rank> rankMap = Map.of(
            "6", SIX_MATCH,
            "5-true", FIVE_MATCH_BONUS,
            "5-false", FIVE_MATCH,
            "4", FOUR_MATCH,
            "3", THREE_MATCH
    );

    private final int matchCount;
    private final long winnings;

    Rank(int matchCount, long winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        if (matchCount == FIVE_MATCH.getMatchCount())
            return rankMap.getOrDefault(matchCount + "-" + hasBonus, NO_MATCH);
        return rankMap.getOrDefault(Integer.toString(matchCount), NO_MATCH);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinnings() {
        return winnings;
    }
}
