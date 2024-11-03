package lotto.model;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int calculateLottoAmount() {
        validate(purchaseAmount);
        return purchaseAmount / 1000;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
