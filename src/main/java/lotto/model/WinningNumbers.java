package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber; // 보너스 번호


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(List<Integer> numbers) {
        int count = 0;
        for(int number: numbers) {
            if(winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }
}
