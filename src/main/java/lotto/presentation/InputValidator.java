package lotto.presentation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.global.ErrorMessage;

public class InputValidator {
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("\\d+");
    private static final int MINIMUM_MONEY_AMOUNT = 0;
    private static final int MONEY_UNIT = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int REQUIRED_LOTTO_NUMBER_COUNT = 6;
    private static final String NUMBER_SEPARATOR = ",";

    private InputValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateMoneyInput(String input) {
        validateIsPositiveInteger(input);
        int money = Integer.parseInt(input);
        validateMoneyAmount(money);
    }

    public static void validateLottoNumbersInput(String input) {
        String[] numbers = splitNumbers(input);
        validateNumbersCount(numbers);
        validateEachLottoNumber(numbers);
        checkForDuplicateNumbers(numbers);
    }

    public static void validateBonusNumberInput(String input, List<Integer> winningNumbers) {
        validateIsPositiveInteger(input);
        int bonusNumber = Integer.parseInt(input);
        validateLottoNumberRange(bonusNumber);
        checkBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateIsPositiveInteger(String input) {
        if (!POSITIVE_INTEGER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateMoneyAmount(int money) {
        if (money <= MINIMUM_MONEY_AMOUNT || money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    private static String[] splitNumbers(String input) {
        if (!input.contains(NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
        return input.split(NUMBER_SEPARATOR);
    }

    private static void validateNumbersCount(String[] numbers) {
        if (numbers.length != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_OF_NUMBERS.getMessage());
        }
    }

    private static void validateEachLottoNumber(String[] numbers) {
        Arrays.stream(numbers).forEach(number -> {
            validateIsPositiveInteger(number);
            validateLottoNumberRange(Integer.parseInt(number));
        });
    }

    private static void checkForDuplicateNumbers(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        if (uniqueNumbers.size() != numbers.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS_IN_LOTTO.getMessage());
        }
    }

    private static void validateLottoNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static void checkBonusNumberNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
