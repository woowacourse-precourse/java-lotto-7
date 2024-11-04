package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static constant.Message.*;

public class Validator {
    private static final int PRICE_UNIT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_STRING.getMessage());
        }
    }

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_STRING.getMessage());
        }
    }

    public static void validateThousandUnit(int amount) {
        if (amount % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_NON_THOUSAND_UNIT.getMessage());
        }
    }

    public static void validateNumericStrings(String[] winningNumbersInputSplits) {
        for (String winningNumberInputSplit : winningNumbersInputSplits) {
            try {
                validateNumericString(winningNumberInputSplit);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ERROR_INCLUDING_NON_NUMERIC_NUMBER.getMessage());
            }
        }
    }

    public static void validateLottoNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateUniqueNumbers(ArrayList<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS.getMessage());
            }
        }
    }

    public static void validateLottoNumbersInRange(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            try {
                validateLottoNumberInRange(number);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ERROR_INCLUDING_OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public static void validateWinningNumbersCount(String[] winningNumbersInputSplits) {
        if (winningNumbersInputSplits.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    public static void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    public static void validateNewNumber(ArrayList<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_NON_NEW_NUMBER.getMessage());
        }
    }
}
