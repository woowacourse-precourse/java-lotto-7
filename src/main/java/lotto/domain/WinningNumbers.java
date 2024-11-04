package lotto.domain;

import java.util.List;
import lotto.exception.LottoValidationException;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber){
        if(winningNumbers.contains(bonusNumber)){
            throw new LottoValidationException(LottoValidationException.DUPLICATED_BONUS_NUMBER_ERROR);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
