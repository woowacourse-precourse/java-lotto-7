package lotto.application.validation;

import lotto.util.ErrorMessages;

public class AmountValidator implements AmountValidation{
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int AMOUNT_UNIT = 1000;

    @Override
    public Integer validate(String input) {
        return validateAndParseAmount(input);
    }
    @Override
    public int validateAndParseAmount(String amountInput) {
        try {
            int amount = Integer.parseInt(amountInput);
            if (amount < MINIMUM_AMOUNT || amount % AMOUNT_UNIT != 0) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT_UNIT.getMessage());
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT_FORMAT.getMessage());
        }
    }
}
