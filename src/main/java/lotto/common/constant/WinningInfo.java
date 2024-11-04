package lotto.common.constant;

import java.text.NumberFormat;
import java.util.Arrays;

public enum WinningInfo {

    FIFTH_PRIZE(3, 5000, "개 일치 ("),
    FOURTH_PRIZE(4, 50000, "개 일치 ("),
    THIRD_PRIZE(5, 1500000, "개 일치 ("),
    SECOND_PRIZE(5, 30000000, "개 일치, 보너스 볼 일치 ("),
    FIRST_PRIZE(6, 2000000000, "개 일치 (");

    private final Integer matchCount;
    private final Integer priceMoney;
    private final String printMessage;

    WinningInfo(Integer matchCount, Integer priceMoney, String printMessage) {
        this.matchCount = matchCount;
        this.priceMoney = priceMoney;
        this.printMessage = printMessage;
    }

    public static WinningInfo getWinningInfoMatchWithCount(Long matchCount, boolean isMatchedBonus) {
        if (isMatchedBonus) {
            return SECOND_PRIZE;
        }
        return Arrays.stream(WinningInfo.values())
                .filter(winningInfo -> winningInfo.matchCount.intValue() == matchCount)
                .findFirst()
                .orElse(null);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPriceMoney() {
        return priceMoney;
    }

    public String toString() {
        return matchCount.toString() + printMessage + NumberFormat.getNumberInstance().format(priceMoney) + "원) - ";
    }
}
