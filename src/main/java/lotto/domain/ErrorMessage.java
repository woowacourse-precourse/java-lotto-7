package lotto.domain;

public enum ErrorMessage {
    INSUFFICIENT_AMOUNT("[ERROR] 금액이 부족합니다."),
    LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_DIVISIBLE("[ERROR] 금액이 로또 가격과 나누어 떨어져야 합니다."),
    CONTAINS_NUMBER("[ERROR] 당첨 번호에 중복된 번호가 있습니다."),
    NULL_INPUT("[ERROR] null이 입력되었습니다."),
    INVALID_RANGE("[ERROR] 숫자의 범위는 1~45이어야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복이 있으면 안됩니다."),
    INVALID_NUMBER("[ERROR] 입력받은 값이 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
