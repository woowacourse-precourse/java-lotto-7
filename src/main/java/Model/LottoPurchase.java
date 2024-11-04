package Model;

import Model.Constant.Constants;

public class LottoPurchase {
    private int lottoPurchase;

    public LottoPurchase(int lottoPurchase) {
        validate(lottoPurchase);
        this.lottoPurchase = lottoPurchase;
    }

    private void validate(int lottoPurchase) {
        if (lottoPurchase % Constants.DIVISOR != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public int get() {
        return lottoPurchase;
    }
}