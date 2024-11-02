package lotto.service;

import java.util.List;
import lotto.constant.LottoConfiguration;
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

    public void validateWinningNumber(String rawWinningNumber) {
        isBlank(rawWinningNumber);
        hasBlankElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
        existNonNumericElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
        existOutOfParseRangeElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
    }

    private void hasBlankElement(String separableInput, String delimiter) {
        if (separableInput.startsWith(delimiter) || separableInput.endsWith(delimiter)) {
            throw new IllegalArgumentException(ValidationFailMessage.EMPTY_INPUT.getMessage());
        }
        List<String> elements = List.of(separableInput.split(delimiter));
        for (String element : elements) {
            isBlank(element);
        }
    }

    private void existNonNumericElement(String separableInput, String delimiter) {
        List<String> elements = List.of(separableInput.split(delimiter));
        for (String element : elements) {
            isNonNumeric(element);
        }
    }

    private void existOutOfParseRangeElement(String separableInput, String delimiter) {
        List<String> elements = List.of(separableInput.split(delimiter));
        for (String element : elements) {
            isOutOfParseRange(element);
        }
    }
}
