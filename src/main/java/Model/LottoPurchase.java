package Model;

import Model.Constant.Constants;

public class LottoPurchase {
    private int purchaseAmount;

    public LottoPurchase(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % Constants.DIVISOR != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public int get() {
        return purchaseAmount;
    }
}