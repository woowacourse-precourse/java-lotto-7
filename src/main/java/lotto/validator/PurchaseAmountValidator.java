package lotto.validator;

import static lotto.controller.LottoController.LOTTO_PRICE;
import static lotto.validator.ValidatorUtils.PURCHASE_AMOUNT_ERROR_MESSAGE;

public class PurchaseAmountValidator implements Validator<Integer> {

    @Override
    public void validate(Integer purchaseAmount) {
        validatePositive(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private void validatePositive(Integer purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }

    private void validateThousandUnit(Integer purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }
}
