package lotto.common;

public enum ExceptionCode {
    PRICE_DOES_NOT_DIVIDE("P001", "로또 구입 금액은 1,000원 단위로 입력해주세요."),
    INVALID_POSITIVE_PRICE("P002", "로또 구입 금액은 양의 정수로 입력해주세요.")
    ;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String message;
    private final String code;

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
