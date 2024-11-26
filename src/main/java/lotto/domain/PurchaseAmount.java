package lotto.domain;

import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / LottoConstants.LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        validatePositive(amount);
        validateThousandUnit(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_POSITIVE);
        }
    }

    private void validateThousandUnit(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_THOUSAND_UNIT);
        }
    }
}
