package lotto.lottery.domain;

import static lotto.global.util.ErrorMessage.INVALID_AMOUNT;
import static lotto.global.util.LottoConst.LOTTO_PRICE;

public abstract class LottoValidator {
    public static void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }
    }
}
