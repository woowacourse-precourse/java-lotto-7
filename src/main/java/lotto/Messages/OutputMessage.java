package lotto.Messages;

public enum OutputMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    WINNING_STATISTICS_SEPARATOR("---"),
    WINNING_STATISTICS("%d개 일치 (%s원) - %d개"),
    WINNING_STATISTICS_SECOND("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
