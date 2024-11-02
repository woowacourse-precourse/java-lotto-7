package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

import java.util.SequencedSet;

import static lotto.constant.NumberConstant.*;

public class WinningNumber {

    SequencedSet<Integer> winningNumber;
    private Integer bonusNumber;

    public WinningNumber(SequencedSet<Integer> winningNumber) {
        validateSize(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validateSize(SequencedSet<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHED_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    public void addBonusNumber(final int number) {
        validateDuplicateNumber(number);

        this.bonusNumber = number;
    }

    private void validateDuplicateNumber(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 다르게 입력해주세요.");
        }
    }
}
