package lotto.model;

import java.util.List;

public class LottoManagementSystem {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoManagementSystem(List<Integer> winningNumbers,int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int compare(List<Integer> numbers){
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }


}
