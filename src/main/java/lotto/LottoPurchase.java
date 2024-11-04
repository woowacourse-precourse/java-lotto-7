package lotto;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoTicket;

public class LottoPurchase {
    final long purchaseAmount;

    public LottoPurchase(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public long getPurchasedLottoCount() {
        return purchaseAmount / LottoTicket.PRICE.getValue();
    }

    private long validate(String inputAmount) {
        long amount;
        try {
            amount = Long.parseLong(inputAmount);
            validatePurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getText());
        }
        return amount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount % LottoTicket.PRICE.getValue() != LottoTicket.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_UNIT.getText());
        } else if (purchaseAmount < LottoTicket.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT.getText());
        }
    }
}
