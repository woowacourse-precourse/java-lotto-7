package lotto.enums;

public enum ErrorCode {
    INPUT_NOT_AVAILABLE("입력이 불가능한 상태입니다."),

    INVALID_INPUT("입력값이 올바르지 않습니다."),
    INVALID_NEGATIVE_AMOUNT("금액은 양수로 입력 해주세요."),
    INVALID_PURCHASE_AMOUNT("금액은 1,000원 단위로 입력해야 합니다."),

    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = ERROR_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
