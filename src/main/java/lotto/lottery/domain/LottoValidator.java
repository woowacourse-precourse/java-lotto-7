package lotto.lottery.domain;

import static lotto.global.util.ErrorMessage.INVALID_AMOUNT;
import static lotto.global.util.ErrorMessage.INVALID_AMOUNT_RANGE;
import static lotto.global.util.LottoConst.LOTTO_PRICE;
import static lotto.global.util.LottoConst.MAX_PRICE;
import static lotto.global.util.LottoConst.MIN_PRICE;

public abstract class LottoValidator {

    public static void validate(int amount) {
        validateAmount(amount);
        validateAmountRange(amount);
    }

    private static void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }
    }

    private static void validateAmountRange(int amount) {
        if (amount < MIN_PRICE || amount > MAX_PRICE) {
            throw new IllegalArgumentException(String.format(INVALID_AMOUNT_RANGE.getMessage(), MIN_PRICE, MAX_PRICE));
        }
    }

}
