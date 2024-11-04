package lotto.Exception;

public enum ExceptionMessage {
    COMMON_ERROR("[ERROR] "),

    WINNING_NUMBER_NOT_NUMERIC("당첨번호를 숫자로만 입력해주세요."),
    DUPLICATE_WINNING_NUMBER("당첨번호와 보너스번호가 중복되면 안됩니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_RANGE_LOTTO_NUMBER("1~45 사이의 수만 가능합니다."),
    DUPLICATE_LOTTO_NUMBER("숫자가 중복되면 안됩니다."),

    ZERO_PURCHASE_AMOUNT("로또를 구매할 수 없습니다."),
    NOT_THOUSAND_UNIT_PURCHASE_AMOUNT("천원 단위로만 입력해주세요."),

    ZERO_MATCH("잘못된 로또 입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(COMMON_ERROR.message, message);
    }

}
