package lotto.model;

import lotto.exception.CustomLottoException;
import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public record WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
    public WinningNumbers {
        validate(winningNumbers, bonusNumber);
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateSize(winningNumbers);
        validateDuplicatesWinningNumbers(winningNumbers);
        validateDuplicatesWinningAndBonus(winningNumbers, bonusNumber);
        validateNumberRange(winningNumbers);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new CustomLottoException(ErrorMessage.NOT_LOTTO_SIZE);
        }
    }

    private void validateDuplicatesWinningNumbers(List<Integer> winningNumbers) {
        HashSet<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (uniqueWinningNumbers.size() != 6) {
            throw new CustomLottoException(ErrorMessage.DUPLICATE_VALUES);
        }
    }

    private void validateDuplicatesWinningAndBonus(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new CustomLottoException(ErrorMessage.DUPLICATE_VALUES);
        }
    }

    private void validateNumberRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new CustomLottoException(ErrorMessage.NOT_NUMBER_RANGE);
            }
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new CustomLottoException(ErrorMessage.NOT_NUMBER_RANGE);
        }
    }
}