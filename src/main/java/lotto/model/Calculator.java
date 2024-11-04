package lotto.model;

import static lotto.constant.LottoValue.LOTTO_PRICE;
import static lotto.exception.ExceptionErrorMessage.INPUT_EXIST_REMAINS_MESSAGE;

public class Calculator {
    private final int REMAINS = 0;
    private static final Calculator instance = new Calculator();

    private Calculator() {

    }

    public static Calculator getInstance() {
        return instance;
    }

    public int getLottoCount(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return calculatePurchaseAmount(purchaseAmount);
    }

    private int calculatePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / LOTTO_PRICE.getValue();
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        validateNumOfRange(purchaseAmount);
        validatePurchaseAmountRemains(purchaseAmount);
    }

    private void validateNumOfRange(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchaseAmountRemains(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % LOTTO_PRICE.getValue() != REMAINS) {
            throw new IllegalArgumentException(INPUT_EXIST_REMAINS_MESSAGE.toString());
        }
    }
}
