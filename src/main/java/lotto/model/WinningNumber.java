package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.enums.Constants.*;
import static lotto.enums.ExceptionMessage.*;

public class WinningNumber {

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);

        this.winningNumber = lotto.getNumbers();
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(int bonusNumber) {

        if (bonusNumber < MIN_LOTTO_NUM.getValue() || bonusNumber > MAX_LOTTO_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
