package lotto.enums;

public enum OutputMessage {
    LOTTO_AMOUNT("구입 금액을 입력해주세요."),
    WINNING_NUMBER("당첨 번호를 입력해주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해주세요."),
    ERROR_PREFIX("[ERROR] "),
    PURCHASE_RESULT("%d개를 구매했습니다.\n"),
    STATISTICS_HEADER("\n당첨 통계"),
    STATISTICS_DIVIDER("---"),
    RANK_RESULT("%s (%,d원) - %d개\n"),
    RETURN_RATE("총 수익률은 %.1f%%입니다.\n"),
    NEW_LINE("\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
