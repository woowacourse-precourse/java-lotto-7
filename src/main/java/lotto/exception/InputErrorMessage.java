package lotto.exception;

public enum InputErrorMessage {
    INPUT_IS_EMPTY("[ERROR] 입력값이 없습니다."),
    INPUT_IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    INPUT_IS_NOT_POSITIVE("[ERROR] 0보다 큰 숫자만 입력 가능합니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
