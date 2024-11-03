package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.List;

public class DrawNumbers {
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;

    public DrawNumbers(WinningNumbers winningNumbers,BonusNumber bonusNumber){
        validateDuplicatedNumber(winningNumbers,bonusNumber);
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }

    private void validateDuplicatedNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getParsedNumbers().contains(bonusNumber.getBonusNumber())){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_TO_WINNING_NUMBERS);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getParsedNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

}
