package lotto.domain;

import lotto.util.ErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record BallNumber(List<Integer> winningNumbers, int bonusNumber) {

    public BallNumber {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbersCountCheck(winningNumbers);
        winningNumbersRangeCheck(winningNumbers);
        winningNumbersDuplicateCheck(winningNumbers);
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        numberRangeCheck(bonusNumber, ErrorCode.INVALID_BONUS_NUMBER);
        bonusNumberDuplicateCheck(bonusNumber, winningNumbers);
    }

    private void winningNumbersCountCheck(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw ErrorCode.INVALID_WINNING_NUMBER_COUNT.exception();
        }
    }

    private void winningNumbersDuplicateCheck(List<Integer> winningNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() > nonDuplicateNumbers.size()) {
            throw ErrorCode.DUPLICATE_WINNING_NUMBER.exception();
        }
    }

    private void winningNumbersRangeCheck(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            numberRangeCheck(number, ErrorCode.INVALID_WINNING_NUMBER);
        }
    }

    private void numberRangeCheck(int number, ErrorCode errorCode) {
        if (number <= 0 || number > 45) {
            throw errorCode.exception();
        }
    }

    private void bonusNumberDuplicateCheck(int bonusNumber, List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number == bonusNumber) {
                throw ErrorCode.DUPLICATE_BONUS_NUMBER.exception();
            }
        }
    }

}
