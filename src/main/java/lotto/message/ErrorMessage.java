package lotto.message;

public enum ErrorMessage {

    INVALID_MONEY_TYPE("[ERROR] 금액은 1000원 단위의 숫자로 입력해 주세요."),
    LOTTO_SIZE_6("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
