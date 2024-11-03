package lotto.validator;

import static lotto.constants.ErrorMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.constants.ErrorMessage.EMPTY_INPUT_ERROR;
import static lotto.constants.ErrorMessage.INVALID_UNIT_ERROR;
import static lotto.constants.ErrorMessage.NUMBER_FORMAT_ERROR;
import static lotto.constants.ErrorMessage.NUMBER_SIZE_ERROR;
import static lotto.constants.ErrorMessage.OUT_OF_RANGE_ERROR;

import java.util.HashSet;
import java.util.List;
import lotto.utils.InputUtils;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {

    private static final int UNIT = 1_000;
    private static final int LIMIT_VALUE = 0;
    private static final int SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public static void validateAmount(String amount) {
        validateBlank(amount);
        int parsedAmount = InputUtils.convertToInt(amount);
        validatePositiveNumber(parsedAmount);
        validateDivisibleByUnit(parsedAmount);
    }

    public static void validateNumbers(List<String> numbers) {
        validateBlank(numbers);
        numbers.forEach(number -> validatePositiveNumber(InputUtils.convertToInt(number)));
        List<Integer> parsedNumbers = InputUtils.convertToIntList(numbers);
        validateLength(parsedNumbers);
        validateRange(parsedNumbers);
        validateDuplicates(parsedNumbers);
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> numbers) {
        validateBlank(bonusNumber);
        int parsedBonus = InputUtils.convertToInt(bonusNumber);
        validatePositiveNumber(parsedBonus);
        validateRange(List.of(parsedBonus));
        validateDuplicateInList(parsedBonus, numbers);
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private static void validateBlank(List<String> inputs) {
        if (inputs.stream().allMatch(StringUtils::isBlank)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private static void validatePositiveNumber(int input) {
        if (input <= LIMIT_VALUE) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    private static void validateDivisibleByUnit(int amount) {
        if ((amount % UNIT) != LIMIT_VALUE) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR.getMessage());
        }
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN_VALUE || num > MAX_VALUE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR.getMessage());
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private static void validateDuplicateInList(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

}
