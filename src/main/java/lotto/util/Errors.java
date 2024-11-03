package lotto.util;

public enum Errors {
    ERROR("[ERROR]"),
    NULL_OR_EMPTY_INPUT("값이 비어있습니다."),
    NOT_A_WHOLE_NUMBER("정수가 아닙니다."),
    NOT_A_LONG("long 범위를 벗어났습니다."),
    NOT_IN_MONEY_RANGE("금액은 "
            + MessageParser.getComma(Constants.MIN_MONEY.getNumber())
            + "부터 "
            + MessageParser.getComma(Constants.MAX_MONEY.getLong())
            + " 사이의 숫자여야 합니다."),
    REMAINDER_EXISTENT("값이 나누어 떨어지지 않습니다."),

    NOT_INTEGER("Integer 범위를 벗어났습니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 "
            + MessageParser.getComma(Constants.LOTTO_NUMBER_COUNT.getNumber())
            + "개여야 합니다."),
    DUPLICATE_NUMBERS("중복된 값이 존재합니다."),
    NOT_IN_LOTTO_RANGE("로또 번호는 "
            + MessageParser.getComma(Constants.MIN_LOTTO_NUMBER.getNumber())
            + "부터 "
            + MessageParser.getComma(Constants.MAX_LOTTO_NUMBER.getNumber())
            + " 사이의 숫자여야 합니다."),

    BONUS_UNDETERMINED("보너스 번호를 대조하는 중 오류가 발생했습니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
