package lotto.domain;

import lotto.util.ErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public BallNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumbers((bonusNumber));

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw ErrorCode.INVALID_LOTTO_NUMBER_COUNT.exception();
        }

        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() > nonDuplicateNumbers.size()) {
            throw ErrorCode.DUPLICATE_LOTTO_NUMBER.exception();
        }
    }

    private void validateBonusNumbers(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw ErrorCode.INVALID_BONUS_NUMBER.exception();
        }
    }
}
