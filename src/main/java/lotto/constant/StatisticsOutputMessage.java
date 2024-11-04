package lotto.constant;

public enum StatisticsOutputMessage {
    START_COMMENT("\n당첨 통계"),
    START_LINE("---"),
    CONTENT_OF_LOTTO_RESULT("%d개 일치 (%s원) - %d개\n"),
    CONTENT_OF_RESULT_FOR_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    StatisticsOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
