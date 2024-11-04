package lotto.constants;

public enum OutputMessage {
    PURCHASE_QUANTITY_MESSAGE("개를 구매했습니다."),
    LINE_BREAK("\n"),
    WINNING_DETAIL_MESSAGE("\n당첨 통계"),
    DIVIDING_LINE("---"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다."),
    LOTTO_DETAIL_FORMAT("%s (%,d원) - %d개\n"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
