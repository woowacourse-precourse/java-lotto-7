package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoRules.NUMBERS_REQUIRED) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage(),
                            LottoRules.NUMBERS_REQUIRED));
        }

        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateNumber(number);
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
            }
        }
    }

    public static void validateNumber(Integer number) {
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
