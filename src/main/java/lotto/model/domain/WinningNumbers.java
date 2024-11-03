package lotto.model.domain;

import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber; // 보너스 번호

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

//    public int getBonusNumber() {
//        return bonusNumber;
//    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return winningNumbers; // 당첨 번호 리스트 반환
    }

    public int countMatch(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }
}
