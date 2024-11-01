package lotto.domain;

import static lotto.message.MessageConstants.MESSAGE_FIFTH;
import static lotto.message.MessageConstants.MESSAGE_FIRST;
import static lotto.message.MessageConstants.MESSAGE_FOURTH;
import static lotto.message.MessageConstants.MESSAGE_SECOND;
import static lotto.message.MessageConstants.MESSAGE_THIRD;

public enum WinningRank {
    FIFTH(3, MESSAGE_FIFTH, 5_000),
    FOURTH(4, MESSAGE_FOURTH, 50_000),
    THIRD(5, MESSAGE_THIRD, 1_500_000),
    SECOND(5, MESSAGE_SECOND, 30_000_000),
    FIRST(6, MESSAGE_FIRST, 2_000_000_000);

    private final int matchCount;
    private final String message;
    private final int prizeMoney;

    WinningRank(int matchCount, String message, int prizeMoney) {
        this.matchCount = matchCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public boolean isMatch(long matchCount, boolean bonusMatch) {
        if (this == THIRD) {
            return matchCount == this.matchCount && !bonusMatch;
        }

        return matchCount == this.matchCount;
    }

    public String getMessage() {
        return message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
