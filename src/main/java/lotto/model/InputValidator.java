package lotto.model;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppConstant.LOTTO_UNIT_PRICE;
import static lotto.common.AppConstant.SPLIT_DELIMITER;
import static lotto.common.AppErrorType.BONUS_NUMBER_DUPLICATE_ERROR;
import static lotto.common.AppErrorType.DIVIDED_BY_PRICE_ERROR;
import static lotto.common.AppErrorType.LOTTO_PRICE_ERROR;
import static lotto.common.AppErrorType.NEGATIVE_NUMBER_ERROR;
import static lotto.common.AppErrorType.NUMBER_DUPLICATE_ERROR;
import static lotto.common.AppErrorType.NUMBER_RANGE_ERROR;
import static lotto.common.AppErrorType.PARSE_NUMBER_ERROR;
import static lotto.common.AppErrorType.WINNING_NUMBER_SIZE_ERROR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.error.InputException;

public class InputValidator {
    public void validateInputMoney(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
        validateOverLottoPrice(input);
        validateDivideByUnit(input);
    }

    public void validateInputWinningNumber(String input) {
        List<String> splitWinningNumber = Arrays.stream(input.split(SPLIT_DELIMITER)).toList();
        validateNumberListSize(splitWinningNumber);
        validateDistinctNumberList(splitWinningNumber);

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
            throw new InputException(PARSE_NUMBER_ERROR);
        }
    }

    private void validatePositiveNumber(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput < 0) {
            throw new InputException(NEGATIVE_NUMBER_ERROR);
        }
    }

    private void validateOverLottoPrice(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput < LOTTO_UNIT_PRICE) {
            throw new InputException(LOTTO_PRICE_ERROR);
        }
    }

    private void validateDivideByUnit(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput % LOTTO_UNIT_PRICE != 0) {
            throw new InputException(DIVIDED_BY_PRICE_ERROR);
        }
    }

    private void validateNumberListSize(List<String> numberList) {
        if (numberList.size() != LOTTO_NUMBER_COUNT) {

            throw new InputException(WINNING_NUMBER_SIZE_ERROR);
        }
    }

    private void validateRangeNumber(String input) {
        int parsedInt = Integer.parseInt(input);

        if (LOTTO_START_RANGE > parsedInt || parsedInt > LOTTO_END_RANGE) {
            throw new InputException(NUMBER_RANGE_ERROR);
        }
    }

    private void validateDistinctNumberList(List<String> winningNumberList) {
        Set<String> distinctWinningNumber = new HashSet<>(winningNumberList);

        if (distinctWinningNumber.size() != winningNumberList.size()) {
            throw new InputException(NUMBER_DUPLICATE_ERROR);
        }
    }
}
