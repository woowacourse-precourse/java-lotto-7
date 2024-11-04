package lotto.domain;

import java.util.Map;

public enum Prize {
    THREE_MATCH(3, false, 5000, "3개 일치"),
    FOUR_MATCH(4, false, 50000, "4개 일치"),
    FIVE_MATCH(5, false, 1500000, "5개 일치"),
    FIVE_MATCH_WITH_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, false, 2000000000, "6개 일치"),
    NONE(0, false, 0, "당첨이 없습니다.");

    private final int matchCount;
    private final boolean matchBonus;
    private final int winnings;
    private final String message;

    Prize(int matchCount, boolean matchBonus, int winnings, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winnings = winnings;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public String getMessage() {
        return message;
    }

    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_WITH_BONUS;
        }

        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize != FIVE_MATCH_WITH_BONUS) {
                return prize;
            }
        }

        return NONE;
    }
}
