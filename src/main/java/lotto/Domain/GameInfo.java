package lotto.Domain;

import lotto.Constants.Error;

public class GameInfo {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private int remainingAmount;
    private int bonusNumber;

    public GameInfo(int purchaseAmount, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.remainingAmount = purchaseAmount % 1000;
        this.bonusNumber = bonusNumber;
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(lotto.Constants.Error.PURCHASE_AMOUNT_LT_MINIMUM.getText());
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getText());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
