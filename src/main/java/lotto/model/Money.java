package lotto.model;

public class Money {
    private final long purchaseAmount;

    public Money(long purchaseAmount) {
        checkPurchaseAmountIsThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public long getThousandUnitCount() {
        return purchaseAmount / 1000;
    }

    private void checkPurchaseAmountIsThousandUnit(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로만 입력해주세요.");
        }
    }
}
