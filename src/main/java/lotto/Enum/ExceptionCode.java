package lotto.Enum;


public enum ExceptionCode {
    INVALID_NUMBERS_LENGTH("LOTTO_01", "[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_RANGE("LOTTO_02", "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("LOTTO_03", "[ERROR] 로또 번호는 중복된 숫자가 올 수 없습니다."),
    INVALID_LOTTO_INPUT("LOTTO_04", "[ERROR] 로또 번호는 숫자와 구분자(,)로만 이루어져야 합니다."),
    INVALID_PRICE("PRICE_01", "[ERROR] 구매 금액은 1000원 단위로만 입력 가능합니다."),
    INVALID_TYPE("TYPE_01", "[ERROR] 숫자만 입력 가능합니다."),
    NULL_INPUT("NULL_01", "[ERROR] 빈 값은 입력될 수 없습니다.");

    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
