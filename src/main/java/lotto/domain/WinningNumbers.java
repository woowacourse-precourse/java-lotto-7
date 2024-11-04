package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoRules;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersDuplication(numbers);
        validateNumberInRange(numbers);
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
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public static void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                                LottoRules.MAX_NUMBER));
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
