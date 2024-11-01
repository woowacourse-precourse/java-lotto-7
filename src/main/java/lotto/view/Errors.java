package lotto.view;

import lotto.util.ConstantNumbers;

public enum Errors {
    ERROR("[ERROR]"),
    NUMBER_REQUEST(ConstantNumbers.LOTTO_PRICE.getNumber() + "원 단위의 금액을 입력해주세요."),
    NULL_OR_EMPTY_INPUT("값이 비어있습니다."),
    NOT_A_NATURAL_NUMBER("자연수가 아닙니다."),
    NOT_A_LONG("long 범위를 벗어났습니다."),
    NOT_IN_RANGE("범위를 벗어났습니다 (" + ConstantNumbers.MIN_MONEY + "~" + ConstantNumbers.MAX_MONEY + ").");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
