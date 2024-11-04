package lotto.common;

public enum ExceptionMessage {
    INVALID_NUMBER_FORMAT("숫자 형식이 잘못되었습니다. 다시 입력해주세요."),
    INVALID_LOTTO_NUMBER_RANGE("1~45 사이의 정수여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_DUPLICATE_LOTTO_NUMBER("번호가 중복되어선 안됩니다."),
    ERROR_MINIMUM_PURCHASE_AMOUNT("1,000원 이상 입력해주세요."),
    ERROR_INVALID_PURCHASE_AMOUNT_UNIT("1,000원 단위로 입력해주세요."),
    ERROR_MAXIMUM_PURCHASE_AMOUNT("로또 구입 금액은 100,000원 이하로 입력해주세요."),

    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
