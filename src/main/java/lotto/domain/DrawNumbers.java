package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.List;

public class DrawNumbers {
    List<Integer> winningNumbers;
    int bonusNumber;

    public DrawNumbers(List<Integer> winningNumbers,int bonusNumber){
        validateDuplicatedNumber(winningNumbers,bonusNumber);
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicatedNumber(List<Integer> winningNumbers,int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_TO_WINNING_NUMBERS);
        }
    }
}
