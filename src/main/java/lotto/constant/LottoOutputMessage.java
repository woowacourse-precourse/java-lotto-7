package lotto.constant;

public enum LottoOutputMessage {
    PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다."),
    LOTTO_WINNING_RESULT_MESSAGE("당첨 통계"),
    LOTTO_RESULT_BOUNDARY_MESSAGE("---"),
    LOTTO_RESULT_RATE_MESSAGE("총 수익률은 "),
    LOTTO_LAST_WORD_MESSAGE("입니다.");

    private final String message;

    LottoOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
