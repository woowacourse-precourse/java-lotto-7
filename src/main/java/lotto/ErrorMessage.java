package lotto;

public enum ErrorMessage {
    INVALID_INPUT_MESSAGE("[ERROR] 구입 금액은 1000 이상의 숫자여야 합니다."),
    INVALID_CASH_MESSAGE("[ERROR] 구입 금액은 1000원 단위여야 합니다."),

    INVALID_WINNING_NUMBER("[ERROR] 유효하지 않은 당첨 번호입니다."),
    INVALID_BONUS_NUMBER("[ERROR] 유효하지 않은 보너스 번호입니다.")
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
