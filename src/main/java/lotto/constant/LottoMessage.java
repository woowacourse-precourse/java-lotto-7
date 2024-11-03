package lotto.constant;

public enum LottoMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계"),
    COUNT_MESSAGE("개\n"),
    TOTAL_RETURN_RATE_MESSAGE("총 수익률은 "),
    END_MESSAGE("%입니다."),
    HORIZON("---"),
    NEW_LINE("\n");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
