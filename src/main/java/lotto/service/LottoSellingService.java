package lotto.service;

import static lotto.exception.Exception.LOTTO_AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.Exception.MINIMUM_LOTTO_COUNT_REQUIRED;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public class LottoSellingService {

    public LottoBundle sell(int amount) {
        validate(amount);
        int lottoCount = amount / Lotto.LOTTO_PRICE;
        return LottoBundle.of(lottoCount);
    }

    private void validate(int amount) {
        validateAtLeastOneLotto(amount);
        validateAmountDivisibility(amount);
    }

    private void validateAtLeastOneLotto(int amount) {
        if (amount < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_COUNT_REQUIRED.getMessage());
        }
    }

    private void validateAmountDivisibility(int amount) {
        if (amount % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }
}
