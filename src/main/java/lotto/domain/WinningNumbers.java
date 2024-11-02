package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;

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

    private void validateWinningNumbers() {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
