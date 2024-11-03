package lotto;

import static lotto.ErrorMessage.NOT_ENOUGH_PURCHASE_AMOUNT;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_EXCEED_LIMIT;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE;
import static lotto.LottoMachine.LOTTO_PRICE;

public class PurchaseAmount {
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final int PERCENTAGE_FACTOR = 100;
    private final int purchaseAmount;

    private PurchaseAmount(final int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount of(final int purchaseAmount) {
        validatePurchaseAmountEnough(purchaseAmount);
        validatePurchaseAmountMultipleLottoPrice(purchaseAmount);
        validatePurchaseAmountExceedLimit(purchaseAmount);
        return new PurchaseAmount(purchaseAmount);
    }


    private static void validatePurchaseAmountEnough(final int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validatePurchaseAmountMultipleLottoPrice(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE.getMessage());
        }
    }

    private static void validatePurchaseAmountExceedLimit(final int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_EXCEED_LIMIT.getMessage());
        }
    }

    public int calculateTotalLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public double calculateReturnRate(final int totalWinningAmount) {
        return (double) totalWinningAmount * PERCENTAGE_FACTOR / purchaseAmount;
    }
}
