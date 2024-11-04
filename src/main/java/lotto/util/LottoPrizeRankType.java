package lotto.util;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum LottoPrizeRankType {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    ZERO(0, false, 0L);

    private final int matchCount;
    private final boolean bonusMatch;
    private final Long prizeMoney;

    LottoPrizeRankType(final int matchCount, final boolean bonusMatch, final Long prizeMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrizeRankType findByMatchCountAndBonusMatch(final int matchCount,
            final boolean bonusMatch) {
        for (LottoPrizeRankType lottoPrizeRankType : values()) {
            if (isPrizeRank(lottoPrizeRankType, matchCount, bonusMatch)) {
                return lottoPrizeRankType;
            }
        }
        return ZERO;
    }

    public static boolean isPrizeRank(final LottoPrizeRankType lottoPrizeRankType,
            final int matchCount,
            final boolean bonusMatch) {

        if (lottoPrizeRankType.matchCount != matchCount) {
            return false;
        }
        return lottoPrizeRankType.bonusMatch == bonusMatch;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public Long getPrizeMoney() {
        return this.prizeMoney;
    }

    public static Map<LottoPrizeRankType, Long> getRankCountMap() {
        final EnumMap<LottoPrizeRankType, Long> map = new EnumMap<>(LottoPrizeRankType.class);
        Arrays.stream(LottoPrizeRankType.values())
                .filter(rank -> rank != LottoPrizeRankType.ZERO)
                .forEach(rank -> map.put(rank, 0L));
        return map;
    }
}
