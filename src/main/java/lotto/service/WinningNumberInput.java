package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.util.ValidationUtil;

public class WinningNumberInput {

    public static List<Integer> getWinningNumbers(String input) {
        List<Integer> numbers = parseInput(input);
        validate(numbers);

        return numbers;
    }

    public static int getBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        ValidationUtil.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static List<Integer> parseInput(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validate(List<Integer> numbers) {
        ValidationUtil.validateNumberCount(numbers);
        ValidationUtil.validateRange(numbers);
        ValidationUtil.validateNoDuplicates(numbers);
    }
}
