package lotto.exception;

import lotto.constants.LottoConstInteger;

public enum InputErrorMessage {
    // 접두사
    ERROR_PREFIX("[ERROR] "),
    // 로또 구입 금액 예외
    PURCHASE_PRICE_NOT_NUMBER("로또 구입 금액에는 숫자만 입력하셔야 합니다."),
    PURCHASE_PRICE_NOT_REACH_AT_LEAST("최소 한 개 이상의 로또를 구입할 수 있는 가격을 입력하셔야 합니다."
            + "(최소 금액 : " + LottoConstInteger.LOTTO_PRICE.getValue() + "원)"),
    PURCHASE_PRICE_CANT_BE_DIVIDED_CLEARLY(LottoConstInteger.LOTTO_PRICE.getValue() + "으로 나눠지는 수를 입력하셔야 합니다."),
    // 로또 당첨 번호 예외
    LOTTO_WINNING_NUMBER_CONTAIN_BAD_INPUT("로또 당첨 번호에는 숫자와 구분자 만을 입력하셔야 합니다."),
    LOTTO_WINNING_NUMBER_NOT_VALID_NUMBER("로또 당첨 번호는 "),

    ;

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
