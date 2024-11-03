package lotto.exception.lottoPrice;

import lotto.exception.ErrorCode;

public enum LottoPriceErrorCode implements ErrorCode {
    INVALID_LOTTO_PRICE("로또 금액은 0 이상 1000 단위여야 합니다.");

    private final String message;

    LottoPriceErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
