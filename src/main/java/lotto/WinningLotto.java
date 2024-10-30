package lotto;

import static lotto.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {
    int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        checkBonusNumberRange(bonusNumber);
        checkDuplication(winningNumbers, bonusNumber);
    }

    private void checkBonusNumberRange(int bonusNumber) {
        try {
            checkSingleNumberRange(bonusNumber);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        }
    }
    private void checkDuplication(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> combinedNumbers = new ArrayList<>(winningNumbers);
        combinedNumbers.add(bonusNumber);
        try {
            super.checkDuplication(combinedNumbers);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }


}
