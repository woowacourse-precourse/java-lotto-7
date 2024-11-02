package lotto.domain;

import static lotto.config.ErrorMessageConstant.DUPLICATED_WINNING_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.INSUFFICIENT_WINNING_NUMBERS_MESSAGE;
import static lotto.config.ErrorMessageConstant.INVALID_RANGE_NUMBER_MESSAGE;
import static lotto.config.GameConstant.LOWER_BOUND_WINNING_NUMBER;
import static lotto.config.GameConstant.NUMBER_OF_WINNING_NUMBER;
import static lotto.config.GameConstant.UPPER_BOUND_WINNING_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoMachine {
    private List<Integer> winningNumbers;

    public LottoMachine() {
        winningNumbers = new ArrayList<>();
    }

    public void assignWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(INSUFFICIENT_WINNING_NUMBERS_MESSAGE);
        }

        if (new HashSet<>(winningNumbers).size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER_MESSAGE);
        }

        for (int winningNumber : winningNumbers) {
            if (winningNumber < LOWER_BOUND_WINNING_NUMBER || winningNumber > UPPER_BOUND_WINNING_NUMBER) {
                throw new IllegalArgumentException(INVALID_RANGE_NUMBER_MESSAGE);
            }
        }
    }
}
