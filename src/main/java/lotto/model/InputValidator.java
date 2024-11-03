package lotto.model;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppConstant.SPLIT_DELIMITER;
import static lotto.common.error.AppErrorType.NEGATIVE_NUMBER_ERROR;
import static lotto.common.error.AppErrorType.NUMBER_RANGE_ERROR;
import static lotto.common.error.AppErrorType.PARSE_NUMBER_ERROR;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public void validateInputMoney(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
    }

    public void validateInputWinningNumber(String input) {
        List<String> splitWinningNumber = Arrays.stream(input.split(SPLIT_DELIMITER)).toList();

        splitWinningNumber.forEach(number -> {
            validateParseNumber(number);
            validateRangeNumber(number);
            validatePositiveNumber(number);
        });
    }

    public void validateInputBonusNumber(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
        validateRangeNumber(input);
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

    private void validateRangeNumber(String input) {
        int parsedInt = Integer.parseInt(input);

        if (LOTTO_START_RANGE > parsedInt || parsedInt > LOTTO_END_RANGE) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
