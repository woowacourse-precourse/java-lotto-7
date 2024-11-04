package lotto.message;

public enum ResultMessage {
    THREE_MATCH_MESSAGE("3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCH_MESSAGE("4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCH_MESSAGE("5개 일치 (1,500,000원) - %d개\n"),
    FIVE_WITH_BONUS_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCH_MESSAGE("6개 일치 (2,000,000,000원) - %d개\n"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
