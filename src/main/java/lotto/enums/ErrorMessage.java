package lotto.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("[ERROR] 사용자 입력은 null, 빈문자열, 공백으로만 이루어진 문자열일 수 없습니다."),
    INVALID_INTEGER_INPUT("[ERROR] 숫자는 정수 값만 입력해야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NEGATIVE_AMOUNT_NOT_ALLOWED("[ERROR] 구입 금액은 1,000원 단위의 양의 정수여야 합니다."),
    DUPLICATE_LOTTO_NUMBER_NOT_ALLOWED("로또 번호는 모두 다른 번호여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1에서 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
