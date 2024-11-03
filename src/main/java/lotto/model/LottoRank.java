package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public enum LottoRank {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000),
    NO_MATCH(0, false, 0);  // 기본값, 일치하지 않는 경우

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoRank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static Map<LottoRank, Integer> initRankMap() {
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
        return results;
    }

    public static LottoRank getRank(int matchCount, boolean bonusMatch) {
        if (isSixMatch(matchCount)) {
            return SIX_MATCH;
        }
        if (isFiveMatchWithBonus(matchCount, bonusMatch)) {
            return FIVE_MATCH_BONUS;
        }
        if (isFiveMatch(matchCount, bonusMatch)) {
            return FIVE_MATCH;
        }
        return getBasicRank(matchCount);
    }

    private static boolean isSixMatch(int matchCount) {
        return matchCount == 6;
    }

    private static boolean isFiveMatch(int matchCount, boolean bonusMatch) {
        return matchCount == 5 && !bonusMatch;
    }

    private static boolean isFiveMatchWithBonus(int matchCount, boolean bonusMatch) {
        return matchCount == 5 && bonusMatch;
    }


    private static LottoRank getBasicRank(int matchCount) {
        if (matchCount == 4) {
            return FOUR_MATCH;
        }
        if (matchCount == 3) {
            return THREE_MATCH;
        }
        return NO_MATCH;
    }

    public int getPrize() {
        return prize;
    }

    //public int getMatchCount() {
    //    return matchCount;
    //}
}
