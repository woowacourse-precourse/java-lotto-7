package lotto;

public enum ExceptionMessage {
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}

