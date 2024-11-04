package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private final List<Integer> numbers;

    public WinningLottoNumbers(List<String> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumbers(List<String> numbers) {
        if (numbers.size() != lotto.LottoRules.NUMBERS_REQUIRED) {
            throw new IllegalArgumentException(
                    String.format(lotto.ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage(),
                            lotto.LottoRules.NUMBERS_REQUIRED));
        }

        Set<String> numberSet = new HashSet<>();
        for (String numberStr : numbers) {
            String trimmedNumber = numberStr.trim();
            validateNumber(trimmedNumber);
            if (!numberSet.add(trimmedNumber)) {
                throw new IllegalArgumentException(lotto.ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
            }
        }
    }

    public static void validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < lotto.LottoRules.MIN_NUMBER || number > lotto.LottoRules.MAX_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(lotto.ErrorMessage.OUT_OF_BOUNDS.getMessage(), lotto.LottoRules.MIN_NUMBER,
                                lotto.LottoRules.MAX_NUMBER));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(lotto.ErrorMessage.NUMBER_NOT_INTEGER.getMessage(), input));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
