package lotto.message;

public enum SystemMessage {

    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO_COUNT("%d개를 구매했습니다."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    SECTION_DIVIDER("---"),
    WINNING_RESULT_FORMAT("%s (%s원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
