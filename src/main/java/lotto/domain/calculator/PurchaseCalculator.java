package lotto.domain.calculator;

import lotto.domain.calculator.Calculator;
import lotto.utils.ErrorMessages;

public class PurchaseCalculator implements Calculator {
    private static final int LOTTO_PRICE = 1000;
    @Override
    public int calculate(int receivedAmount) {
        validateAmount(receivedAmount);
        return receivedAmount / LOTTO_PRICE;
    }

    private void validateAmount(int amount){
        validateMinimumAmount(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private void validateMinimumAmount(int amount){
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateDivisibleByLottoPrice(int amount){
        if(amount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_AMOUNT_UNIT.getMessage());
        }
    }
}
