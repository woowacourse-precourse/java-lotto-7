package lotto.common;

public enum ExceptionCode {
    PRICE_DOES_NOT_DIVIDE("P001", "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요."),
    INVALID_POSITIVE_PRICE("P002", "[ERROR] 로또 구입 금액은 양의 정수로 입력해주세요."),
    INVALID_PRICE("P003", "[ERROR] 로또 구입 금액은 숫자로 입력해주세요."),
    INVALID_LOTTO_SIZE("L001", "[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DOES_NOT_UNIQUE("L002", "[ERROR] 로또 번호는 중복되지 않은 숫자여야합니다.")
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
