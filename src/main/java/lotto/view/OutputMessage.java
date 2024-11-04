package lotto.view;

public enum OutputMessage {
    INPUT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_RESULT("%d개를 구매했습니다.\n"),
    RESULT_HEADER("당첨 통계\n---"),
    MATCH_RESULT("%s 일치 (%,d원) - %d개\n"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}