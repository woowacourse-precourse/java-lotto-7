package lotto.constant;

public enum Message {
    PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE("\n%d개를 구매했습니다."),
    WINNING_STATS("당첨 통계\n---"),
    TOTAL_EARNINGS_RATE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}

