package lotto.common.error;

public enum InputErrorMessage implements ErrorMessage {
    // 입력 예외 처리
    INVALID_INPUT_TYPE("숫자가 아닌 문자를 입력하셨습니다."),
    NULL_INPUT("입력 값이 존재하지 않습니다.");

    private static final String ERROR_PREFIX = "[ERROR]";
    private final String info;
    private final String message;

    InputErrorMessage( String message) {
        this.info = ERROR_PREFIX;
        this.message = message;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
