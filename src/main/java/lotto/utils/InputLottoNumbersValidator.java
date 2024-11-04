package lotto.utils;

public class InputLottoNumbersValidator {
    private void validate1000Multiple(String input) {
        int budget = Integer.parseInt(input);
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_1000_MULTIPLE.getMessage());
        }
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_INPUT_TYPE.getMessage());
        }
    }

    public void validateSplitDelimiter(String input) {
        if (!input.matches(Message.REGEX_MATCH_PATTERN.getMessage())) {
            throw new IllegalArgumentException(Message.DEFAULT_HEADER.getMessage() + Message.INVALID_DELIMITER.getMessage());
        }
    }

    public void validateBudget(String input) {
        validate1000Multiple(input);
        validateNumberFormat(input);
    }
}
