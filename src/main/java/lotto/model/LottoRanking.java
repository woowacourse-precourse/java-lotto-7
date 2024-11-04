package lotto.model;

import lotto.constants.AppConstants;

public enum LottoRanking {
    FIRST(AppConstants.MATCH_COUNT_FIRST, AppConstants.BONUS_MATCH_NOT_REQUIRED, AppConstants.PRIZE_FIRST),
    SECOND(AppConstants.MATCH_COUNT_SECOND, AppConstants.BONUS_MATCH_REQUIRED, AppConstants.PRIZE_SECOND),
    THIRD(AppConstants.MATCH_COUNT_THIRD, AppConstants.BONUS_MATCH_NOT_REQUIRED, AppConstants.PRIZE_THIRD),
    FOURTH(AppConstants.MATCH_COUNT_FOURTH, AppConstants.BONUS_MATCH_NOT_REQUIRED, AppConstants.PRIZE_FOURTH),
    FIFTH(AppConstants.MATCH_COUNT_FIFTH, AppConstants.BONUS_MATCH_NOT_REQUIRED, AppConstants.PRIZE_FIFTH),
    NONE(AppConstants.MATCH_COUNT_NONE, AppConstants.BONUS_MATCH_NOT_REQUIRED, AppConstants.PRIZE_NONE);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRanking(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRanking findRanking(int matchCount, boolean bonusMatch) {
        for (LottoRanking ranking : values()) {
            if (ranking.matchCount == matchCount && ranking.matchBonus == bonusMatch) {
                return ranking;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}