package lotto;

public enum ErrorMessages {
    INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_INPUT("[ERROR] 올바른 숫자를 입력해 주세요.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}