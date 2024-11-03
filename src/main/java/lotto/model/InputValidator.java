package lotto.model;

import static lotto.common.AppConstant.SPLIT_DELIMITER;
import static lotto.common.AppErrorType.NEGATIVE_NUMBER_ERROR;
import static lotto.common.AppErrorType.PARSE_NUMBER_ERROR;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public void validateInputWinningNumber(String input) {
        List<String> splitWinningNumber = Arrays.stream(input.split(SPLIT_DELIMITER)).toList();
        splitWinningNumber.forEach(this::validateInputNumber);
    }

    public void validateInputNumber(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
    }

    private void validateParseNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(PARSE_NUMBER_ERROR.getMessage());
        }
    }

    private void validatePositiveNumber(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput <= 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }
}
