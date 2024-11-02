package lotto.message;

public enum LottoMessage {

    DISPLAY_LOTTO_COUNT("%s개를 구매했습니다."),
    DISPLAY_LOTTO_RESULT("당첨 통계"),
    DISPLAY_LOTTO_RESULT_BOUNDARY("---");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
