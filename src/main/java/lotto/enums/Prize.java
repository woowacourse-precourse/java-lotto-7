package lotto.enums;

import static lotto.enums.Message.BONUS_MATCH_MESSAGE;
import static lotto.enums.Message.MATCH_MESSAGE;

public enum Prize {
    THREE_MATCH(3, "5,000"),
    FOUR_MATCH(4, "50,000"),
    FIVE_MATCH(5, "1,500,000"),
    FIVE_BONUS_MATCH(-5, "30,000,000"),
    SIX_MATCH(6, "2,000,000,000");

    private final int matchCount;
    private final String prizeAmount;

    Prize(int matchCount, String prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public String createMessage(int count) {
        if (this == FIVE_BONUS_MATCH) {
            return String.format(BONUS_MATCH_MESSAGE, prizeAmount, count);
        }
        return String.format(MATCH_MESSAGE, matchCount, prizeAmount, count);
    }
}
