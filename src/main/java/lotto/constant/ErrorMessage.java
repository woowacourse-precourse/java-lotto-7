package lotto.constant;

public enum ErrorMessage {
    NULL_INPUT_ERROR("Null이 입력되었습니다."),
    EMPTY_INPUT_ERROR("입력된 값이 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
