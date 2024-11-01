package lotto.enums;

public enum ErrorCode {
    INVALID_INPUT("[ERROR] 입력값이 올바르지 않습니다."),
    INVALID_NEGATIVE_AMOUNT("[ERROR] 금액은 양수로 입력 해주세요."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 금액은 1,000원 단위로 입력해야 합니다."),

    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 번호가 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
