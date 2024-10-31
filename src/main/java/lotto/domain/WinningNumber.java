package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

import java.util.SequencedSet;

import static lotto.constant.NumberConstant.*;

public class WinningNumber {

    SequencedSet<Integer> winningNumber;

    public WinningNumber(SequencedSet<Integer> winningNumber) {
        validateSize(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validateSize(SequencedSet<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHED_WINNING_NUMBER_COUNT.getMessage());
        }
    }
}
