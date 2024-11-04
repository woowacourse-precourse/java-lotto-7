package lotto.validator;

import lotto.error.ErrorMessage;

public class CostValidator implements Validator<Integer> {
    @Override
    public void validate(Integer cost) {
        validateIsNotNegative(cost);
        validateIsPositive(cost);
        validateIsDivisibleByThousand(cost);
    }

    private void validateIsNotNegative(Integer cost) {
        if (cost < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    private void validateIsPositive(Integer cost) {
        if (cost < 1000) {
            throw new IllegalArgumentException(ErrorMessage.BELOW_MINIMUM_AMOUNT.getMessage());
        }
    }

    private void validateIsDivisibleByThousand(Integer cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

}
