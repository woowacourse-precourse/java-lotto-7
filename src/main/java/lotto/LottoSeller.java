package lotto;

import static lotto.exception.Exception.LOTTO_AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.Exception.MINIMUM_LOTTO_COUNT_REQUIRED;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private LottoSeller() {
    }

    public static LottoBundle sell(int amount) {
        validate(amount);
        int lottoCount = amount / LOTTO_PRICE;
        return LottoBundle.of(lottoCount);
    }

    private static void validate(int amount) {
        validateAtLeastOneLotto(amount);
        validateAmountDivisibility(amount);
    }

    private static void validateAtLeastOneLotto(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_COUNT_REQUIRED.getMessage());
        }
    }

    private static void validateAmountDivisibility(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }
}
