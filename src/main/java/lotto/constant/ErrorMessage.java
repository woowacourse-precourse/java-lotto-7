package lotto.constant;

public enum ErrorMessage {
    NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_LENGTH("6개의 당첨 번호를 입력해야 합니다."),
    INVALID_NUMBER_FORMAT("입력값은 숫자만 가능합니다."),
    DUPLICATE_NUMBER("로또 번호에는 중복값이 존재하지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("[ERROR] %s", message);
    }
}
