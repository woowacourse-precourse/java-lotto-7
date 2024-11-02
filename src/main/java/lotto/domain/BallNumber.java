package lotto.domain;

import lotto.util.ErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record BallNumber(List<Integer> winningNumbers, int bonusNumber) {

    public BallNumber {
        validateWinningNumbers(winningNumbers);
        validateBonusNumbers((bonusNumber));
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        // 당첨 번호 숫자가 6개인지 검사
        if (winningNumbers.size() != 6) {
            throw ErrorCode.INVALID_WINNING_NUMBER_COUNT.exception();
        }

        // 당첨 번호 중 중복이 없는지 검사
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() > nonDuplicateNumbers.size()) {
            throw ErrorCode.DUPLICATE_WINNING_NUMBER.exception();
        }
    }

    private void validateBonusNumbers(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw ErrorCode.INVALID_BONUS_NUMBER.exception();
        }
    }
}
