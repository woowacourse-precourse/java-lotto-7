package lotto.constant;

public enum MessageConstant {
    OUTPUT_PURCHASE_TICKET("%d개를 구매했습니다."),
    OUTPUT_PURCHASE_TICKET_INFO("[%s]"),
    OUTPUT_WINNING_STATISTICS_HEADER("당첨 통계"),
    OUTPUT_WINNING_STATISTICS_SEPARATOR("---"),
    OUTPUT_PROFIT_RATE("총 수익률은 %s%%입니다."),

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    NEWLINE("\n");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
