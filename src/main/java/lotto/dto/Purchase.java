package lotto.dto;

import java.math.BigInteger;

public class Purchase {
    BigInteger money;
    BigInteger amount;

    public Purchase(BigInteger money) {
        this.money = money;
        this.amount = money.divide(BigInteger.valueOf(1000L));
    }

    public BigInteger getMoney() {
        return money;
    }
    public BigInteger getAmount() {
        return amount;
    }
}
