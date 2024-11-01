package lotto.view;

import lotto.util.ConstantNumbers;

public enum Errors {
    ERROR("[ERROR]"),
    NUMBER_REQUEST(ConstantNumbers.LOTTO_PRICE.getNumber() + "원 단위의 금액을 입력해주세요."),
    NOT_AN_INTEGER("정수가 아닙니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
