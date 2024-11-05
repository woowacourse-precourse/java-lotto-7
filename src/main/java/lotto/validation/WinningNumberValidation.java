package lotto.validation;

import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;

public class WinningNumberValidation {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_NUMBER_COUNT = 6;

    private WinningNumberValidation() {
    }

    public static void validate(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        validateWinningNumberCount(numbers);
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new LottoException(LottoErrorMessage.NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(LottoErrorMessage.DUPLICATE_WINNING_NUMBERS);
        }
    }

    private static void validateWinningNumberCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new LottoException(LottoErrorMessage.INVALID_NUMBER_COUNT);
        }
    }
}