package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    EMPTY(PrizeConstants.EMPTY_PRIZE_MONEY, PrizeConstants.EMPTY_MATCH_COUNT,
            (matchCount, containsBonusNumber) -> matchCount < PrizeConstants.THREE_MATCH_COUNT),
    THREE_MATCH(PrizeConstants.THREE_MATCH_PRIZE_MONEY, PrizeConstants.THREE_MATCH_COUNT,
            (matchCount, containBonusNumber) -> matchCount == PrizeConstants.THREE_MATCH_COUNT),
    FOUR_MATCH(PrizeConstants.FOUR_MATCH_PRIZE_MONEY, PrizeConstants.FOUR_MATCH_COUNT,
            (matchCount, containBonusNumber) -> matchCount == PrizeConstants.FOUR_MATCH_COUNT),
    FIVE_MATCH_WITHOUT_BONUS_BALL(PrizeConstants.FIVE_MATCH_WITHOUT_BONUS_PRIZE_MONEY, PrizeConstants.FIVE_MATCH_COUNT,
            (matchCount, containBonusNumber) -> matchCount == PrizeConstants.FIVE_MATCH_COUNT && !containBonusNumber),
    FIVE_MATCH_WITH_BONUS_BALL(PrizeConstants.FIVE_MATCH_WITH_BONUS_PRIZE_MONEY, PrizeConstants.FIVE_MATCH_COUNT,
            (matchCount, containBonusNumber) -> matchCount == PrizeConstants.FIVE_MATCH_COUNT && containBonusNumber),
    SIX_MATCH(PrizeConstants.SIX_MATCH_PRIZE_MONEY, PrizeConstants.SIX_MATCH_COUNT,
            (matchCount, containBonusNumber) -> matchCount == PrizeConstants.SIX_MATCH_COUNT);
    
    private final int prizeMoney;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> isWinningCondition;

    Prize(int prizeMoney, int matchCount, BiPredicate<Integer, Boolean> isWinningCondition) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.isWinningCondition = isWinningCondition;
    }

    public static Prize determinePrize(int matchCount, boolean containsBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isWinningCondition.test(matchCount, containsBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    private static class PrizeConstants {
        public static final int EMPTY_PRIZE_MONEY = 0;
        public static final int EMPTY_MATCH_COUNT = 0;
        public static final int THREE_MATCH_COUNT = 3;
        public static final int THREE_MATCH_PRIZE_MONEY = 5_000;
        public static final int FOUR_MATCH_COUNT = 4;
        public static final int FOUR_MATCH_PRIZE_MONEY = 50_000;
        public static final int FIVE_MATCH_COUNT = 5;
        public static final int FIVE_MATCH_WITHOUT_BONUS_PRIZE_MONEY = 1_500_000;
        public static final int FIVE_MATCH_WITH_BONUS_PRIZE_MONEY = 30_000_000;
        public static final int SIX_MATCH_COUNT = 6;
        public static final int SIX_MATCH_PRIZE_MONEY = 2_000_000_000;
    }
}
