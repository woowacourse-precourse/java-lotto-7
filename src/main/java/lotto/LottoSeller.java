package lotto;

import java.math.BigInteger;

public class LottoSeller {
    private final int price;

    public LottoSeller(int price) {
        this.price = price;
    }

    public int calculateQuantityWith(BigInteger amount) {
        return amount.divide(BigInteger.valueOf(price)).intValue();
    }
}
