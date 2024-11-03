package lotto.message;

public enum ResultMessage {

    // View message
    DISPLAY_LOTTO_RESULT("당첨 통계"),
    DISPLAY_LOTTO_RESULT_BOUNDARY("---");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}