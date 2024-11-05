package lotto.enums;

public enum OutputMessage {

    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    NOTICE_PURCHASE_COUNT("\n%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
