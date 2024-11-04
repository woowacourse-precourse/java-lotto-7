package lotto.week3.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.week3.global.error.message.ErrorMessage;

public class WinningNumberRequestDto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumberRequestDto(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_MUST_BE_SIX.getMessage());
        }
        Set<Integer> uniqueNumber = new HashSet<>(winningNumbers);
        if (uniqueNumber.size() != 6 || uniqueNumber.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_MUST_BE_UNIQUE_AND_IN_RANGE.getMessage());
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MUST_BE_UNIQUE_AND_IN_RANGE.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
