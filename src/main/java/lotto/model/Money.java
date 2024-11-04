package lotto.model;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.exception.custom.MoneyException;

import java.util.Objects;

public class Money {

    private final int amount;

    private Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int getPossibleLottoCount() {
        return amount / LottoGameConfig.LOTTO_PRICE_UNIT;
    }

    public double getRateOfReturn(int winningAmount) {
        return (double) winningAmount / amount * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new LottoGameException(MoneyException.INVALID_AMOUNT);
        }
    }

}
