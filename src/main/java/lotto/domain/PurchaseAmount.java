package lotto.domain;

import java.util.Objects;

import static lotto.common.Constants.*;
import static lotto.common.ValidationUtils.*;

public class PurchaseAmount {
    private final Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public PurchaseAmount(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.amount = Integer.parseInt(purchaseAmount);
    }

    public final boolean compareAmount (Integer amount) {
        return Objects.equals(this.amount, amount);
    }

    private static void validatePurchaseAmount (String rawPurchaseAmount) {
        validateNumber(rawPurchaseAmount, INVALID_PRICE_UNIT);
        validateUnderMax(rawPurchaseAmount, MAX_PURCHASE_AMOUNT, UP_MAX_PURCHASE_AMOUNT);

        Integer purchaseAmount = Integer.parseInt(rawPurchaseAmount);
        validateAmountUnit(purchaseAmount, LOTTO_PRICE_UNIT, INVALID_PRICE_UNIT);

    }

}
