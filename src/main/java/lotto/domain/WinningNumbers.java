package lotto.domain;

import java.util.List;
import lotto.exception.InvalidInputException;
import lotto.exception.LottoStateException;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateDuplicate(winningNumbers, bonusNumber);
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
        for (Integer number : winningNumbers) {
            if (number < 0) {
                throw new InvalidInputException(InvalidInputException.NEGATIVE_INPUT_ERROR);
            }
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < 0) {
            throw new InvalidInputException(InvalidInputException.NEGATIVE_INPUT_ERROR);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidInputException(InvalidInputException.DUPLICATED_BONUS_NUMBER_ERROR);
        }
    }

}
