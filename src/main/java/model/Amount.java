package model;

import java.math.BigInteger;

public class Amount {
    private final BigInteger purchaseAmount;
    public Amount(BigInteger purchaseAmount){
        this.purchaseAmount = purchaseAmount;
    }

    public BigInteger getPurchaseAmount() {
        return purchaseAmount;
    }
}
