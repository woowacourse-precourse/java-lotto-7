package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.utils.Message;

public class InputLottoNumbersValidator {

    public static void validateWinningNumbers(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_RANGE.getMessage());
            }
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_DUPLICATES_NUMBER.getMessage());
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_RANGE.getMessage());
        }
    }

    private static void validateNoDuplicateWithWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage()
                            + Message.INVALID_DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }
}
