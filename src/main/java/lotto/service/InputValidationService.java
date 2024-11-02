package lotto.service;

import lotto.constant.RegularExpression;
import lotto.constant.ValidationFailMessage;

public class InputValidationService {

    public void validatePurchasePrice(String rawPurchasePrice) {
        isBlank(rawPurchasePrice);
        isNonNumeric(rawPurchasePrice);
        isOutOfParseRange(rawPurchasePrice);
    }

    private void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ValidationFailMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void isNonNumeric(String input) {
        if (!input.matches(RegularExpression.INTEGER_PATTERN.getExpression())) {
            throw new IllegalArgumentException(ValidationFailMessage.NON_NUMERIC_INPUT.getMessage());
        }
    }

    private void isOutOfParseRange(String numericInput) {
        try {
            Integer.parseInt(numericInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ValidationFailMessage.OUT_OF_PARSE_RANGE.getMessage());
        }
    }
}
