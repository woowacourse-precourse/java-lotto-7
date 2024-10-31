package lotto.exception;

import lotto.constants.LottoConstInteger;

public enum ErrorMessage {
    // 접두사
    ERROR_PREFIX("[ERROR] "),
    //로또 구입 금액 예외
    PURCHASE_PRICE_NOT_A_NUMBER("로또 구입 금액에는 숫자만 입력하셔야 합니다."),
    PURCHASE_PRICE_NOT_REACH_AT_LEAST("최소 한 개 이상의 로또를 구입할 수 있는 가격을 입력하셔야 합니다."
            + "(최소 금액 : " + LottoConstInteger.LOTTO_PRICE.getValue() + "원)"),
    PURCHASE_PRICE_CANT_DIVIDE_CLEARLY(LottoConstInteger.LOTTO_PRICE.getValue() + "으로 나눠지는 수를 입력하셔야 합니다."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
