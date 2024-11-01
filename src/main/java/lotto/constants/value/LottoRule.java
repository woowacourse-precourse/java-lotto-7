package lotto.constants.value;

import lotto.constants.Constants;

public enum LottoRule implements Constants<Integer> {
    COMBINATION_LENGTH(6),
    MINIMUM_NUMBER_RANGE(1),
    MAXIMUM_NUMBER_RANGE(45),
    LOTTO_PRICE(1000);

    private final Integer value;

    LottoRule(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getInstance() {
        return value;
    }
}
