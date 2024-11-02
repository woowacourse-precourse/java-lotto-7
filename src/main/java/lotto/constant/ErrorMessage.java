package lotto.constant;

public enum ErrorMessage {
    NUMBERS_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBERS_RANGE_ERROR("[ERROR] 로또 범위를 벗어나는 숫자가 입력되었습니다"),
    NUMBERS_DUPLICATE_ERROR("[ERROR] 중복되는 번호가 존재합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
