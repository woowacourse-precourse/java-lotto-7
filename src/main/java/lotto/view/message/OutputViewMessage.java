package lotto.view.message;

public enum OutputViewMessage {
    PRINT_PURCHASE_LOTTO_COUNT("개를 구매했습니다."),
    PRINT_WINNING_LOTTO("당첨 통계\n---\n"),
    PRINT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.\n"),
    THREE_MATCH_PRICE("3개 일치 (5,000원) - "),
    FOUR_MATCH_PRICE("4개 일치 (50,000원) - "),
    FIVE_MATCH_PRICE("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_MATCH_PRICE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_BONUS_MATCH_PRICE("6개 일치 (2,000,000,000원) - "),
    SUFFIX("개\n");

    public final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }
}
