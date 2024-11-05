package lotto.view;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_COUNT_PURCHASED("%d개를 구매했습니다."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_HEADER("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    THREE_MATCH("3개 일치 (%s원) - %d개\n"),
    FOUR_MATCH("4개 일치 (%s원) - %d개\n"),
    FIVE_MATCH("5개 일치 (%s원) - %d개\n"),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    SIX_MATCH("6개 일치 (%s원) - %d개\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
