package lotto.utils;

public class InputLottoNumbersValidator {
    private void validate1000Multiple(String input) {
        int number = Integer.parseInt(input);
        if (number % 1000 != 0) {
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

    private void validateSplitDelimiter(String input) {
        if (!input.matches("^([1-9]|[1-4][0-5])(,([1-9]|[1-4][0-5])){5}$")) {
            throw new IllegalArgumentException(Message.DEFAULT_HEADER.getMessage() + Message.INVALID_DELIMITER.getMessage());
        }
    }
}
