package lotto.exception.errorMessage;

public enum IllegalArgumentExceptionMessage {
    NUMBER_FORMAT("숫자 형식의 값을 입력해주세요"),
    PURCHASE_AMOUNT_UNIT("구입 금액은 1000원 단위여야 합니다."),
    PURCHASE_AMOUNT_NOT_NATURE("구입 금액은 자연수값이어야 합니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호에 중복된 번호가 있습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1 - 45범위의 경계를 포함한 값이여야합니다.");

    private final String message;

    IllegalArgumentExceptionMessage(String message) {
        String ERROR = "[ERROR] ";
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
