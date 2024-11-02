package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.constants.ErrorMessages;

public class WinningNumbers {
    private final Set<Integer> numbers;

    public WinningNumbers(String input) {
        this.numbers = parseWinningNumbers(input);
        validateWinningNumbers();
    }

    private Set<Integer> parseWinningNumbers(String input) {
        String[] splitNumbers = input.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String numStr : splitNumbers) {
            int number = Integer.parseInt(numStr.trim());
            validateNumberRange(number);
            if (!numbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER);
            }
        }
        return numbers;
    }
}
