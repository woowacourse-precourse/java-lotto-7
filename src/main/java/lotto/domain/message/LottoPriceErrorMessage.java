package lotto.domain.message;

import static lotto.domain.rule.LottoRules.AUTO_LOTTO_PRICE;

public enum LottoPriceErrorMessage {

    INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO("[ERROR] 로또 가격은 " + AUTO_LOTTO_PRICE.getValue() + " 단위로 나누어떨어져야 합니다.(0원도 불가)");

    private final String message;

    LottoPriceErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
