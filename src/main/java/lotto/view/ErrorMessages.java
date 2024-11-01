package lotto.view;

import lotto.util.ConstantNumbers;

public enum ErrorMessages {
    ERROR("[ERROR] "),
    NUMBER_REQUEST(ConstantNumbers.LOTTO_PRICE.getNumber() + "원 단위의 금액을 입력해주세요."),
    NON_NUMERIC_CONTAINED(ERROR.getMessage() + "숫자만 입력할 수 있습니다. " + NUMBER_REQUEST.getMessage());

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
