package lotto.constants;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
