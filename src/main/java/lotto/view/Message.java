package lotto.view;

public enum Message {
    PURCHASED_NUMBERS("8개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    PIECES("개"),
    WON("원"),
    LINE_DIVIDE("---"),
    MATCH_3("3개 일치 (5,000원) - "),
    MATCH_4("4개 일치 (50,000원) - "),
    MATCH_5("5개 일치 (1,500,000원) - "),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_6("6개 일치 (2,000,000,000원) - "),
    TOTAL_PRIZE("총 당첨금: "),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
