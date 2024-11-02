package lotto;

import static lotto.ExceptionMessages.INVALID_INPUT;

import java.util.List;

public class InputValidator {

    public void validateAmount(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public void validateWinNumber(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
