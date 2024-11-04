package lotto;

public class LottoQuantityCalculator {
    private static final int PRICE_PER_LOTTO = 1000;

    public int calculateLottoQuantity(int validatedPurchaseAmount) {
        return validatedPurchaseAmount / PRICE_PER_LOTTO;
    }
}
