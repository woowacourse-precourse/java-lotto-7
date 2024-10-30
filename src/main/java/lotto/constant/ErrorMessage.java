package lotto.constant;

public enum ErrorMessage {
    NULL_INPUT_ERROR("[ERROR] Null이 입력되었습니다."),
    EMPTY_INPUT_ERROR("[ERROR] 입력된 값이 없습니다."),
    NUMBER_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
