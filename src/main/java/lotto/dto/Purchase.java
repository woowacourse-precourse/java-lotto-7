package lotto.dto;

import java.math.BigInteger;

public class Purchase {
    BigInteger money;

    public Purchase(BigInteger money) {
        this.money = money;
    }

    public BigInteger getMoney() {
        return money;
    }
}
