package lotto.global;

public enum ErrorCode {

    DIVISION_ERROR("1000의 배수만 입력 해 주세요."),
    MINUS_NUMBER_ERROR("양수를 입력 해 주세요");

    private final String message;

    public String getMessage() {
        return message;
    }

    ErrorCode(String message) {
        this.message = message;
    }
}
