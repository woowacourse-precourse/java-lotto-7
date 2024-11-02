package lotto;

public enum ExceptionMessages {
    INVALID_INPUT("[ERROR] 올바른 형식의 입력이 아닙니다."),
    ERROR_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
