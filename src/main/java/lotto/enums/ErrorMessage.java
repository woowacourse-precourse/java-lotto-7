package lotto.enums;

public enum ErrorMessage {
    NUMBERS_RANGE("[ERROR] 번호는 1에서 45 사이의 숫자만 가능합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 유효하지 않는 숫자 형식입니다. "),
    DUPLICATE_NUMBERS("[ERROR] 중복된 로또 번호가 존재합니다."),
    REQUIRED_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_PURCHASE_UNIT("[ERROR] 로또는 1,000원 단위로 구입할 수 있습니다."),
    NEGATIVE_AMOUNT("[ERROR] 구입 금액은 양수만 입력할 수 있습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getText() {
        return errorMessage;
    }
}