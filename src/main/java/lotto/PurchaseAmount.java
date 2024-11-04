package lotto;

import static lotto.ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.MAX_LOTTO_PURCHASE_AMOUNT;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < LOTTO_PRICE || amount > MAX_LOTTO_PURCHASE_AMOUNT)
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_RANGE);
        if (amount % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT);
    }

    public int getPurchasableQuantity() {
        return amount/LOTTO_PRICE;
    }

    public double calculateTotalProfitRate(LottoWinningResult lottoWinningResult) {
        int totalPrize = lottoWinningResult.getTotalPrize();
        return (double) totalPrize/amount*100;
    }
}
