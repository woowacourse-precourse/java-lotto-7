package lotto.contants.message;

public enum ErrorMessage {
    PURCHASE_PRICE("구입 금액 단위는 1,000원입니다."),
    SPILT_EMPTY("쉼표(,) 사이에 숫자가 존재해야합니다."),
    LOTTO_NUMBER_RANGE("로또 번호 범위는 1~45입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
