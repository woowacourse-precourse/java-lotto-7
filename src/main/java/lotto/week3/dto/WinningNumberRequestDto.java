package lotto.week3.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 입니다. ");
        }
        Set<Integer> uniqueNumber = new HashSet<>(winningNumbers);
        if (uniqueNumber.size() != 6 || uniqueNumber.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 고유한 숫자여햐 합니다.");
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
