package lotto.controller;

import static lotto.exception.ErrorBase.BONUS_NUMBER_BLANK;
import static lotto.exception.ErrorBase.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorBase.BONUS_NUMBER_NON_NUMERIC;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_DUPLICATE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_INVALID_SIZE;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_BLANK;
import static lotto.exception.ErrorBase.BLANK_WINNING_NUMBERS;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_NON_NUMERIC;
import static lotto.exception.ErrorBase.WINNING_NUMBERS_NON_NUMERIC;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.LottoConstants;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {
    public static Long validatePurchaseAmount(String input) {
        validateNotBlank(input, PURCHASE_AMOUNT_BLANK.getMessage());
        return parseLong(input, PURCHASE_AMOUNT_NON_NUMERIC.getMessage());
    }

    public static List<Integer> validateWinningLottos(String input) {
        validateNotBlank(input, BLANK_WINNING_NUMBERS.getMessage());
        List<Integer> numbers = parseIntegerList(input, WINNING_NUMBERS_NON_NUMERIC.getMessage());

        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }

        return numbers;
    }

    public static Integer validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateNotBlank(bonusNumber, BONUS_NUMBER_BLANK.getMessage());

        Integer parsedNum = parseInteger(bonusNumber, BONUS_NUMBER_NON_NUMERIC.getMessage());
        if (winningNumbers.contains(parsedNum)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
        return parsedNum;
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
