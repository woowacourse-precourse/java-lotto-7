package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<String> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumbers(List<String> numbers) {
        if (numbers.size() != LottoRules.NUMBERS_REQUIRED) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage(),
                            LottoRules.NUMBERS_REQUIRED));
        }

        Set<String> numberSet = new HashSet<>();
        for (String numberStr : numbers) {
            String trimmedNumber = numberStr.trim();
            validateNumber(trimmedNumber);
            if (!numberSet.add(trimmedNumber)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
            }
        }
    }

    public static void validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                                LottoRules.MAX_NUMBER));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.NUMBER_NOT_INTEGER.getMessage(), input));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
