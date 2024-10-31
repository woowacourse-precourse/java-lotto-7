package lotto.exception.input;

import lotto.exception.ErrorCode;

public enum InputErrorCode implements ErrorCode {
    LOTTO_PRICE_NOT_DIVISIBLE_BY_1000("로또 구입 금액은 1000원 단위로 입력 해야합니다."),
    INVALID_LOTTO_NUMBER_PATTERN("로또 번호는 1-45까지 숫자 6개가 쉼표(,)로 구분되어야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 로또 번호는 1-45까지의 숫자 중 하나여야 합니다.");

    private final String message;

    InputErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
