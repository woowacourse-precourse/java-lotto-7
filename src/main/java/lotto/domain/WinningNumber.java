package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

import java.util.Collections;
import java.util.List;
import java.util.SequencedSet;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.NumberConstant.*;

public class WinningNumber {

    List<Integer> winningNumber;
    private Integer bonusNumber;

    public WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber.getNumbers();
    }

    public void addBonusNumber(final int number) {
        if (this.bonusNumber != null) {
            throw new IllegalArgumentException(ALREADY_IN_BONUS_NUMBER.getMessage());
        }
        validateDuplicateNumber(number);

        this.bonusNumber = number;
    }

    private void validateDuplicateNumber(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(CAN_NOT_DUPLICATE_NUMBER_IN_WINNING_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
