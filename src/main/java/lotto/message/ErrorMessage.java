package lotto.message;

public enum ErrorMessage {
    NOT_DIVISIBLE_ERROR_MESSAGE("금액은 1,000원으로 나누어 떨어져야 합니다."),
    NUMBER_FORMAT_ERROR_MESSAGE("숫자만 입력 가능합니다."),
    NOT_POSITIVE_ERROR_MESSAGE("양수만 입력 가능합니다."),
    INVALID_COUNT_ERROR_MESSAGE("로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE_ERROR_MESSAGE("로또 번호는 1 이상 45 이하의 정수여야 합니다."),
    DUPLICATE_NUMBER_ERROR_MESSAGE("중복된 숫자는 허용되지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
