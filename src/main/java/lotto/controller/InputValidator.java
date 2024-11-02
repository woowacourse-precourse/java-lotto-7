package lotto.controller;

import static lotto.exception.ErrorBase.BONUS_NUMBER_BLANK;
import static lotto.exception.ErrorBase.BONUS_NUMBER_NON_NUMERIC;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_BLANK;
import static lotto.exception.ErrorBase.BLANK_WINNING_NUMBERS;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_NON_NUMERIC;
import static lotto.exception.ErrorBase.WINNING_NUMBERS_NON_NUMERIC;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {
    public static Long validatePurchaseAmount(String input) {
        validateNotBlank(input, PURCHASE_AMOUNT_BLANK.getMessage());
        return parseLong(input, PURCHASE_AMOUNT_NON_NUMERIC.getMessage());
    }

    public static List<Integer> validateWinningLottos(String input) {
        validateNotBlank(input, BLANK_WINNING_NUMBERS.getMessage());
        return parseIntegerList(input, WINNING_NUMBERS_NON_NUMERIC.getMessage());
    }

    public static Integer validateBonusNumber(String input) {
        validateNotBlank(input, BONUS_NUMBER_BLANK.getMessage());
        return parseInteger(input, BONUS_NUMBER_NON_NUMERIC.getMessage());
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
