package lotto.enums;

public enum OutputMessage {
    // 출력 메시지
    LOTTO_COUNT("%d개를 구매했습니다."),
    START_SQUARE_BRACKET("["),
    FINISH_SQUARE_BRACKET("]"),
    COMMA(","),
    SPACE(" "),
    ENTER("\n"),
    WINNING_STATISTICS("당첨 통계"),
    SECTION("---"),
    THREE_MATCHES("3개 일치 (5,000원) - %d개"),
    FOUR_MATCHES("4개 일치 (50,000원) - %d개"),
    FIVE_MATCHES("5개 일치 (1,500,000원) - %d개"),
    FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개"),
    WINNING_RESULT("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
