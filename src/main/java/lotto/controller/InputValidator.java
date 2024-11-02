package lotto.controller;

import static lotto.exception.ErrorBase.BLANK_BONUS_NUMBER;
import static lotto.exception.ErrorBase.BLANK_PURCHASE_AMOUNT;
import static lotto.exception.ErrorBase.BLANK_WINNING_NUMBERS;
import static lotto.exception.ErrorBase.NON_NUMERIC_BONUS_NUMBER;
import static lotto.exception.ErrorBase.NON_NUMERIC_PURCHASE_AMOUNT;
import static lotto.exception.ErrorBase.NON_NUMERIC_WINNING_NUMBERS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {
    public static Long validatePurchaseAmount(String input) {
        validateNotBlank(input, BLANK_PURCHASE_AMOUNT.getMessage());
        return parseLong(input, NON_NUMERIC_PURCHASE_AMOUNT.getMessage());
    }

    public static List<Integer> validateWinningLottos(String input) {
        validateNotBlank(input, BLANK_WINNING_NUMBERS.getMessage());
        return parseIntegerList(input, NON_NUMERIC_WINNING_NUMBERS.getMessage());
    }

    public static Integer validateBonusNumber(String input) {
        validateNotBlank(input, BLANK_BONUS_NUMBER.getMessage());
        return parseInteger(input, NON_NUMERIC_BONUS_NUMBER.getMessage());
    }

    private static void validateNotBlank(String input, String errorMessage) {
        if (StringUtils.isBlank(input.trim())) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static Long parseLong(String input, String errorMessage) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static Integer parseInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static List<Integer> parseIntegerList(String input, String errorMessage) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
