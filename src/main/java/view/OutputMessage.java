package view;

public enum OutputMessage {

    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_WINNING_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    OUTPUT_WINNING_RESULT_MESSAGE("당첨 통계\n---"),
    OUTPUT_RETURN_RATE_MESSAGE("총 수익률은 %.1f%%입니다."),
    OUTPUT_ELEMENT_RESULT_MESSAGE("%s - %d개");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
