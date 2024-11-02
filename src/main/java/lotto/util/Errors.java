package lotto.util;

public enum Errors {
    ERROR("[ERROR]"),
    MONEY_REQUEST(InputParser.getComma(Constants.LOTTO_PRICE.getNumber()) + "원 단위의 금액을 입력해주세요."),
    NULL_OR_EMPTY_INPUT("값이 비어있습니다."),
    NOT_A_WHOLE_NUMBER("정수가 아닙니다."),
    NOT_A_LONG("long 범위를 벗어났습니다."),
    NOT_IN_RANGE("범위를 벗어났습니다 ("
            + InputParser.getComma(Constants.MIN_MONEY.getNumber())
            + "~"
            + InputParser.getComma(Constants.MAX_MONEY.getLong())
            + ")."),
    REMAINDER_EXISTENT("값이 나누어 떨어지지 않습니다."),

    NOT_INTEGER("Integer 범위를 벗어났습니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 "
            + InputParser.getComma(Constants.LOTTO_NUMBER_COUNT.getNumber())
            + "개여야 합니다."),
    DUPLICATE_NUMBERS("중복된 값이 존재합니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
