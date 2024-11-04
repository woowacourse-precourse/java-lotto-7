package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoRules;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersDuplication(numbers);
        this.numbers = numbers;
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoRules.WINNING_NUMBERS_REQUIRED) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage(),
                            LottoRules.WINNING_NUMBERS_REQUIRED));
        }
    }

    private static void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateNumberInRange(number);
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
            }
        }
    }

    public static void validateNumberInRange(int number) {
        if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                            LottoRules.MAX_NUMBER));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
