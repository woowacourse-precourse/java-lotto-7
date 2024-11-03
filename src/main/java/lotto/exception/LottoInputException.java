package lotto.exception;

import static lotto.constant.GlobalConstant.MAX_NUMBER;
import static lotto.constant.GlobalConstant.MIN_NUMBER;
import static lotto.constant.GlobalConstant.ROUND_PICK;
import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.message.ErrorMessage.INPUT_NOT_NUMERIC;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_FORMAT_INVALID;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_SIZE_INVALID;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class LottoInputException {
    public static void validateBonusNumberInput(String input) {
        validateForWhitespace(input);
        validateNumericInput(input);
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumbers(numbers);
        validateLottoNumbersRange(numbers);
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateBonusNumberNotInWinningNumbers(numbers, bonusNumber);
        validateLottoNumbersRange(numbers);
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != ROUND_PICK) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_INVALID.getMessage());
        }
    }

    public static void validateDuplicateNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (Integer number : inputNumbers) {
            if (!numbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    public static void validateLottoNumbersRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_INVALID.getMessage());
        }

    }

    public static void validateLottoNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_INVALID.getMessage());
            }
        }
    }

    public static void validateWinningNumbers(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (!(Character.isDigit(c) || c == ',')) {
                throw new IllegalArgumentException(WINNING_NUMBERS_FORMAT_INVALID.getMessage());
            }
        }
    }


    public static void validateForWhitespace(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC.getMessage());
        }
    }

    public static void validateNumericInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(INPUT_NOT_NUMERIC.getMessage());
            }
        }
    }

    public static void validateBonusNumberNotInWinningNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
