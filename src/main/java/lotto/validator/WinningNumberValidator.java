package lotto.validator;

import static lotto.validator.ValidatorUtils.WINNING_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.isNumberInRange;

import java.util.List;

public class WinningNumberValidator implements Validator<List<Integer>> {

    private static final Integer LOTTO_NUMBER_COUNT = 6;

    @Override
    public void validate(List<Integer> winningNumber) {
        validateNumberCount(winningNumber);
        validateWinningNumbersRange(winningNumber);
    }

    private void validateNumberCount(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumber) {
        for (Integer number : winningNumber) {
            if (!isNumberInRange(number)) {
                throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE);
            }
        }
    }
}
