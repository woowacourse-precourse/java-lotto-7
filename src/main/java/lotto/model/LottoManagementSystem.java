package lotto.model;

import java.util.List;

public class LottoManagementSystem {

    private final List<Integer> winningNumbers;

    public LottoManagementSystem(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
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
