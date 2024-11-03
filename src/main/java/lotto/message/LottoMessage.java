package lotto.message;

public enum LottoMessage {

    // View message
    DISPLAY_LOTTO_COUNT("%s개를 구매했습니다."),
    DISPLAY_LOTTO_RESULT("당첨 통계"),
    DISPLAY_LOTTO_RESULT_BOUNDARY("---"),

    // Error message
    OUT_OF_RANGE_LOTTO_AMOUNT("구매 가능한 로또 수량을 초과했습니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
