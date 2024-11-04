package lotto.validator;

import lotto.error.ErrorMessage;

public class BonusNumberInputValidator implements Validator<String> {
    @Override
    public void validate(String input) {
        validateIsInteger(input);
    }

    private void validateIsInteger(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }
}
