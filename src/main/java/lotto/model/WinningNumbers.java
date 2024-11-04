package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.enums.LottoBoundInfo;
import lotto.enums.WinningNumbersErrorMessage;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String rawInput) {
        validateIsNumberAndComma(rawInput);
        validateIsNestedComma(rawInput);
        List<Integer> winningNumbers = Arrays.stream(rawInput.split(",")).map(Integer::parseInt).toList();
        validateIsSixElement(winningNumbers);
        validateIsElementInRange(winningNumbers);
        validateIsUnique(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateIsNumberAndComma(String rawInput) {
        if (!rawInput.matches("[0-9,]+")) {
            throw new IllegalArgumentException(WinningNumbersErrorMessage.ONLY_NUMBER_AND_COMMAS.getMessage());
        }
    }

    private void validateIsNestedComma(String rawInput) {
        if (rawInput.contains(",,") || rawInput.startsWith(",") || rawInput.endsWith(",")) {
            throw new IllegalArgumentException(WinningNumbersErrorMessage.INVALID_COMMA.getMessage());
        }
    }

    private void validateIsSixElement(List<Integer> numbers) {
        if (numbers.size() != LottoBoundInfo.LOTTO_NUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException(WinningNumbersErrorMessage.INVALID_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateIsElementInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LottoBoundInfo.MAXIMUM_NUMBER.getInfo() || number < LottoBoundInfo.MINIMUM_NUMBER.getInfo()) {
                throw new IllegalArgumentException(WinningNumbersErrorMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateIsUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoBoundInfo.LOTTO_NUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException(WinningNumbersErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

}
