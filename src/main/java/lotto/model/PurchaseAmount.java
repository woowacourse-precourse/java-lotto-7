package lotto.model;

import lotto.constants.ErrorMessages;

public class PurchaseAmount {
    static final int PURCHASE_UNIT_AMOUNT = 1000;
    static final int MAX_PURCHASE_AMOUNT = 100000;
    static final int MIN_PURCHASE_AMOUNT = 1000;

    private final int amount;

    private PurchaseAmount(String userInput) {
        int inputAmount = convertToValidType(userInput);
        validate(inputAmount);
        amount = inputAmount;
    }

    public static PurchaseAmount from(String userInput) {
        return new PurchaseAmount(userInput);
    }

    private void validate(int userInput) {
        validateMinAmount(userInput);
        validateMaxAmount(userInput);
        validateUnit(userInput);
    }

    private void validateMinAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessages.MIN_AMOUNT.formatMessage(MIN_PURCHASE_AMOUNT));
        }
    }

    private void validateMaxAmount(int amount) {
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessages.MAX_AMOUNT.formatMessage(MAX_PURCHASE_AMOUNT));
        }
    }

    private void validateUnit(int amount) {
        if (amount % PURCHASE_UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessages.UNIT_AMOUNT.formatMessage(PURCHASE_UNIT_AMOUNT));
        }
    }

    private int convertToValidType(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌값은 입력할 수 없습니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
