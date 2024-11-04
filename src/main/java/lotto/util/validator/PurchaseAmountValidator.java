package lotto.util.validator;


import static lotto.common.Constants.LOTTO_PRICE;
import static lotto.util.ErrorMessage.*;

public class PurchaseAmountValidator implements Validator<String> {

    @Override
    public void validate(String input) {
        checkNullOrBlank(input);
        int amount = parseAmount(input);
        checkNaturalNumber(amount);
        checkAmountMin(amount);
        checkAmountUnit(amount);
    }

    private void checkNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_BLANK.getMessage());
        }
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT.getMessage());
        }
    }

    private void checkNaturalNumber(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_NATURAL_NUMBER.getMessage());
        }
    }

    private void checkAmountMin(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MIN.getMessage());
        }
    }

    private void checkAmountUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }
    }

}
