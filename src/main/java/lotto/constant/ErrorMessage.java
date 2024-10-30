package lotto.constant;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 값을 입력해 주세요."),
    NOT_NATURAL_NUMBER("[ERROR] 구입 금액은 자연수여야 합니다."),
    NOT_THOUSAND_PRICE("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
