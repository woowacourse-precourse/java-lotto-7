package lotto.util;

import java.util.List;

import static lotto.constants.LottoConstants.*;
import static lotto.error.LottoError.*;

public class LottoValidator {

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_NON_POSITIVE_AMOUNT.getMessage());
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static void validateNumberCount(List<Integer> numbers, int requiredCount) {
        if (numbers.size() != requiredCount) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers, REQUIRED_LOTTO_NUMBERS);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateLottoNumbers(winningNumbers);
    }

    public static void validateBonusNumber(int bonus, List<Integer> winningNumbers) {
        validateNumberInRange(bonus);
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_PARSE.getMessage());
        }
    }
}
