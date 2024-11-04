package lotto.message;

public enum OutputMessage {
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    PURCHASE_QUANTITY_OUTPUT_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATICS_OUTPUT_MESSAGE("당첨 통계\n---"),
    WINNING_COUNT_OUTPUT_MESSAGE("%d개 일치 (%s원) - %d개");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
