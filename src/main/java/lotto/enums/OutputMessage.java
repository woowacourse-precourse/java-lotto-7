package lotto.enums;

public enum OutputMessage {
    LOTTO_COUNT_SUFFIX("개를 구매했습니다."),
    LOTTO_STATISTICS_RESULT("당첨 통계\n---"),
    LOTTO_PROFIT_RATE("총 수익률은 %s입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
