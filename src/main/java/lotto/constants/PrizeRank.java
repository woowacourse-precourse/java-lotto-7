package lotto.constants;

import java.util.Arrays;

public enum PrizeRank {

    MATCH_FAIL(0, false, 0, "낙첨"),
    MATCH_THREE(3, false, 5_000, "3개 일치 (5,000원) - "),
    MATCH_FOUR(4, false, 50_000, "4개 일치 (50,000원) - "),
    MATCH_FIVE(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    MATCH_FIVE_WITH_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_SIX(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private static final int BONUS_CONDITION_COUNT = 5;

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prizeMoney;
    private final String message;

    PrizeRank(int matchCount, boolean isBonusMatch, int prizeMoney, String message) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static PrizeRank getPrizeRankByMatchCountAndBonus(int matchCount, boolean isBonusMatch) {
        if (matchCount == BONUS_CONDITION_COUNT) {
            return Arrays.stream(values())
                    .filter(rank -> rank.matchCount == matchCount && rank.isBonusMatch == isBonusMatch)
                    .findAny().orElse(MATCH_FAIL);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny().orElse(MATCH_FAIL);
    }
}
