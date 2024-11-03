package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.info.LottoInfo;
import lotto.message.ErrorMessage;

public class WinningNumbersValidator {
    public static List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers = parseAndValidateInput(input);
        validateUniqueNumbers(winningNumbers);
        validateRange(winningNumbers);
        return winningNumbers;
    }

    private static List<Integer> parseAndValidateInput(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != LottoInfo.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT_ERROR_MESSAGE.getMessage());
        }

        List<Integer> numbers = new ArrayList<>();
        for (String s : tokens) {
            String token = s.trim();
            numbers.add(parseInteger(token));
        }
        return numbers;
    }

    private static int parseInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoInfo.MIN_NUMBER.getNumber() || number > LottoInfo.MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
            }
        }
    }
}
