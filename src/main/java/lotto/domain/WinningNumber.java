package lotto.domain;


import java.util.Collections;
import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class WinningNumber {

    List<Integer> winningNumber;
    private BonusNumber bonusNumber;

    public WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber.getNumbers();
    }

    public void addBonusNumber(final BonusNumber bonusNumber) {
        if (this.bonusNumber != null) {
            throw new IllegalArgumentException(ALREADY_IN_BONUS_NUMBER.getMessage());
        }
        validateDuplicateNumber(bonusNumber.getBonusNumber());

        this.bonusNumber = bonusNumber;
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
        return bonusNumber.getBonusNumber();
    }
}
