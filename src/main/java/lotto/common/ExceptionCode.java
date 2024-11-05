package lotto.common;

public enum ExceptionCode {
    PRICE_DOES_NOT_DIVIDE("P001", "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요."),
    INVALID_POSITIVE_PRICE("P002", "[ERROR] 로또 구입 금액은 양의 정수로 입력해주세요."),
    INVALID_NUMBER("N001", "[ERROR] 숫자로 입력해주세요."),
    INVALID_DELIMITER("N002", "[ERROR] 잘못된 구분자를 입력했습니다. 구분자는 쉼표(,)를 입력해주세요."),
    BONUS_NUMBER_DOES_NOT_UNIQUE("N003", "[ERROR] 당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요."),
    INVALID_LOTTO_SIZE("L001", "[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DOES_NOT_UNIQUE("L002", "[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다."),
    INVALID_RANGE_NUMBER("L003", "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.")
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
