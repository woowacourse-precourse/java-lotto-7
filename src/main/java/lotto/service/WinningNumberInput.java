package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.util.ValidationUtil;

public class WinningNumberInput {

    public static List<Integer> getWinningNumbers(final String input) {
        final List<Integer> numbers = parseInput(input);
        validate(numbers);

        return numbers;
    }

    public static int getBonusNumber(final String input, final List<Integer> winningNumbers) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        ValidationUtil.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static List<Integer> parseInput(final String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validate(final List<Integer> numbers) {
        ValidationUtil.validateNumberCount(numbers);
        ValidationUtil.validateRange(numbers);
        ValidationUtil.validateNoDuplicates(numbers);
    }
}
