package lotto.constant;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Rank;

public enum OutputMessage {
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    STATISTICS_MESSAGE("당첨 통계"),
    LINE_SEPARATOR("---"),
    MATCHING_COUNT_MESSAGE(" - %d개"),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMatchingCountMessage(int matchingCount) {
        return String.format(message, matchingCount);
    }

    public String getEarningRateMessage(double earningRate) {
        return String.format(message, earningRate);
    }

    public String getMessage() {
        return message;
    }
}
