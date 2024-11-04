package lotto.validator;

import lotto.error.ErrorMessage;

public class CostInputValidator implements Validator<String> {
    @Override
    public void validate(String input) {
        validateIsInteger(input);
        validateIsWithinIntRange(input);
    }

    private void validateIsInteger(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    private void validateIsWithinIntRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
