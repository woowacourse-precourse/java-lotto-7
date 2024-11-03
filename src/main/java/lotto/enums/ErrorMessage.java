package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 금액은 숫자로 입력해야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
