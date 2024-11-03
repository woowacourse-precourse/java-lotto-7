package lotto.error;

public enum NumberErrorMessage implements ErrorMessage {
    NOT_ALLOWED_NUMBER("허용되지 않은 숫자입니다."),
    IS_NOT_NUMBER("문자는 입력할 수 없습니다.");
    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
