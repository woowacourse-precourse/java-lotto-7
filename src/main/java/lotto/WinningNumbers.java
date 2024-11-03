package lotto;

import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_WINNING_NUMBER;
import static lotto.constant.ErrorMessage.NOT_SIX_WINNING_NUMBER;

import java.util.List;
import lotto.util.DuplicateWinningNumberException;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    public List<Integer> loadWinningNumbers() {
        return winningNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_WINNING_NUMBER.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new DuplicateWinningNumberException();
        }

        for (int winningNumber : numbers) {
            if (winningNumber < WINNING_NUMBER_MIN
                    || winningNumber > WINNING_NUMBER_MAX) {
                throw new IllegalArgumentException(NOT_NUMBER_RANGE_WINNING_NUMBER.getMessage());
            }
        }
    }
}
