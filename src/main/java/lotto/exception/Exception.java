package lotto.exception;

public enum Exception {
    // 구입 금액
    ONLY_NUMERIC_INPUT_FOR_MONEY("1000이상의 숫자만 입력 가능합니다"),
    ONLY_DIVISIBLE_BY_THOUSAND("로또 구입 금액은 1000원 단위만 가능합니다."),
    //번호 공통 사항
    INVALID_NUMBER_RANGE("1이상 45이하의 숫자만 입력 가능합니다."),
    INVALID_LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    //당첨 번호
    INVALID_WINNING_NUMBERS_INPUT_TYPE_AND_DELIMITER("당첨 번호는 숫자만 가능하며 구분자는 쉼표(,)입니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),
    //보너스 번호
    DUPLICATE_BONUS_AND_WINNING_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
