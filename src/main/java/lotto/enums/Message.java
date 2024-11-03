package lotto.enums;

public enum Message {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    WINNING_STATISTICS_HEADER("\n당첨 통계\n---"),
    MATCH_RESULT("%d개 일치 (%,d원) - %d개\n"),
    MATCH_WITH_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    ERROR_PREFIX("[ERROR] ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
