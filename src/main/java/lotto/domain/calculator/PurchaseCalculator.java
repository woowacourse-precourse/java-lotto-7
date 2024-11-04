package lotto.domain.calculator;

import lotto.utils.ErrorMessages;
import lotto.utils.NumberConstants;

public class PurchaseCalculator implements Calculator<Integer, Integer> {
    @Override
    public Integer calculate(Integer purchaseAmount) {
        validateAmount(purchaseAmount);
        return purchaseAmount / NumberConstants.LOTTO_PRICE.getNumber();
    }

    private void validateAmount(int amount) {
        validateMinimumAmount(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private void validateMinimumAmount(int amount) {
        if (amount < NumberConstants.LOTTO_PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % NumberConstants.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_AMOUNT_UNIT.getMessage());
        }
    }
}
