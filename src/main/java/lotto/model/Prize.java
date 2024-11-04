package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    Prize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    private static final Map<Integer, Prize> PRIZE_MAP = new HashMap<>();

    static {
        PRIZE_MAP.put(3, THREE_MATCH);
        PRIZE_MAP.put(4, FOUR_MATCH);
        PRIZE_MAP.put(5, FIVE_MATCH);
        PRIZE_MAP.put(6, SIX_MATCH);
    }

    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        Prize prize = PRIZE_MAP.get(matchCount);
        return getPrizeWithoutConditions(prize, matchCount, bonusMatch);
    }

    private static Prize getPrizeWithoutConditions(Prize prize, int matchCount, boolean bonusMatch) {
        if (prize == null) {
            return null;
        }
        if (matchCount == 5) {
            return handleFiveMatch(bonusMatch);
        }
        return prize;
    }

    private static Prize handleFiveMatch(boolean bonusMatch) {
        if (bonusMatch) {
            return FIVE_MATCH_BONUS;
        }
        return FIVE_MATCH;
    }
}

