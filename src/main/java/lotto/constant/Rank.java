package lotto.constant;

import java.util.Map;

public enum Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000),
    NO_MATCH(0, 0);

    private static final String MATCH_BONUS_SEPARATOR = "-";
    private static final String SIX_MATCH_KEY = "6";
    private static final String FIVE_MATCH_BONUS_KEY = "5" + MATCH_BONUS_SEPARATOR + "true";
    private static final String FIVE_MATCH_KEY = "5" + MATCH_BONUS_SEPARATOR + "false";
    private static final String FOUR_MATCH_KEY = "4";
    private static final String THREE_MATCH_KEY = "3";

    private static final Map<String, Rank> rankMap = Map.of(
            SIX_MATCH_KEY, SIX_MATCH,
            FIVE_MATCH_BONUS_KEY, FIVE_MATCH_BONUS,
            FIVE_MATCH_KEY, FIVE_MATCH,
            FOUR_MATCH_KEY, FOUR_MATCH,
            THREE_MATCH_KEY, THREE_MATCH
    );

    private final int matchCount;
    private final long winnings;

    Rank(int matchCount, long winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        String key = matchCount == FIVE_MATCH.getMatchCount()
                ? matchCount + MATCH_BONUS_SEPARATOR + hasBonus
                : Integer.toString(matchCount);
        return rankMap.getOrDefault(key, NO_MATCH);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinnings() {
        return winnings;
    }
}
