package lotto.machine;

import java.util.List;

public enum PrizeStatus {
    THREE_MATCH(5000, "3개 일치 (5,000원)", 3, false),
    FOUR_MATCH(50000, "4개 일치 (50,000원)", 4, false),
    FIVE_MATCH(1500000, "5개 일치 (1,500,000원)", 5, false),
    FIVE_MATCH_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)", 5, true),
    SIZE_MATCH(2000000000, "6개 일치 (2,000,000,000원)", 6, false);

    private final int prizeMoney;
    private final String statusMessage;
    private final int matchCount;
    private final boolean isRequireToMatchBonusNumber;

    PrizeStatus(int prizeMoney, String statusMessage, int matchCount, boolean isRequireToMatchBonusNumber) {
        this.prizeMoney = prizeMoney;
        this.statusMessage = statusMessage;
        this.matchCount = matchCount;
        this.isRequireToMatchBonusNumber = isRequireToMatchBonusNumber;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getIsRequireToMatchBonusNumber() {
        return isRequireToMatchBonusNumber;
    }
}