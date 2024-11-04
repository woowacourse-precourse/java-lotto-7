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
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT);
        }
    }

    public int get() {
        return lottoPurchase;
    }
}