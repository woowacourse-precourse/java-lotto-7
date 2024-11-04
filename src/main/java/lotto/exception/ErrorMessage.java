package lotto.exception;

public enum ErrorMessage {
    NOT_MULTIPLE_THOUSAND("1000의 배수가 아닙니다."),
    DUPLICATE_VALUES("중복된 값이 입력되었습니다."),
    NOT_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    NOT_NUMBER_RANGE("번호는 1 ~ 45 사이의 값이어야 합니다."),
    NOT_INTEGER_NUMBER("정수인 숫자만 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return "[ERROR] " + message;
    }
}
