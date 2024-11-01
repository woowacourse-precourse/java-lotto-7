package lotto.money.infrastructure;

import lotto.money.domain.Money;
import lotto.buyer.validator.MoneyValidator;
import lotto.util.Convertor;

public class PurchaseAmount implements Money {
    private final long amount;
    private PurchaseAmount(long amount) {
        this.amount = amount;
    }
    public static PurchaseAmount of(String input) {
        long amount = Convertor.stringToLong(input);
        MoneyValidator.validate(amount);
        return new PurchaseAmount(amount);
    }

    @Override
    public long getMoney() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
