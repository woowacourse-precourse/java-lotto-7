package lotto.model;

import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class Amount {
    private static final String AMOUNT_REGEXP = "^[0-9]+$";
    private static final int AMOUNT_MIN = 1000;
    private final int amount;

    public Amount(String inputAmount) {
        validateInput(inputAmount);
        int amount = parseAmount(inputAmount);
        validateMin(amount);
        validateDivision(amount);

        this.amount = amount;
    }

    private void validateInput(String inputAmount) {
        if (!Pattern.matches(AMOUNT_REGEXP, inputAmount)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_TYPE.getMessage());
        }
    }

    private void validateMin(int amount) {
        if (amount < AMOUNT_MIN) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_MIN.getMessage());
        }
    }

    private void validateDivision(int amount) {
        if (amount % AMOUNT_MIN != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_DIVISION.getMessage());
        }
    }

    public int parseAmount(String inputAmount) {
        return Integer.parseInt(inputAmount);
    }

    public int getAmount() {
        return amount;
    }
}
