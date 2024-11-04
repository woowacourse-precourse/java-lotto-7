package lotto.domain;

public class Revenue {
    private final float returnRate;

    public Revenue(int purchaseAmount, int totalAmount) {
        this.returnRate = calculateReturnRate(purchaseAmount, totalAmount);
    }

    public float getReturnRate() {
        return returnRate;
    }

    private float calculateReturnRate(int purchaseAmount, int totalAmount) {
        if (isZero(totalAmount)) {
            return 0;
        }
        return (float) totalAmount / purchaseAmount * 100;
    }

    private boolean isZero(int value) {
        return value == 0;
    }
}
