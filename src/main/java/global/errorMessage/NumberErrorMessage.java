package global.errorMessage;

public enum NumberErrorMessage {
    OUT_OF_RANGE("로또 번호는 1 이상 45 이하의 숫자여야 합니다."),
    NOT_A_NUMBER("숫자를 입력해 주세요.")
    ;
    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
