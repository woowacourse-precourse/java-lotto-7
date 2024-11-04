package lotto.message;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_RESULT_TITLE("당첨 통계\n---"),
    OUTPUT_LOTTOS_RETURNS("총 수익률은 %.1f%%입니다."),
    OUTPUT_LOTTOS_COUNT("%d개를 구매했습니다.")
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(int count) {
        return String.format(this.message, count);
    }
}
