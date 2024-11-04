package lotto.domain;

import static lotto.constant.Number.MAX_LOTTO_NUMBER;
import static lotto.constant.Number.MIN_LOTTO_NUMBER;

import lotto.Lotto;
import lotto.exception.ExceptionCode;

public class PrizeNumbers {
    private final Lotto prizeNumbers;
    private final Integer bonus;

    public PrizeNumbers(Lotto prizeNumbers, Integer bonus) {
        this.prizeNumbers = prizeNumbers;
        this.bonus = bonus;
        validBonus();
    }

    public Lotto getLotto() {
        return prizeNumbers;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void validBonus() {
        if (bonus < MIN_LOTTO_NUMBER || bonus > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_NUMBER_SIZE.getMessage());
        }

    }

}
