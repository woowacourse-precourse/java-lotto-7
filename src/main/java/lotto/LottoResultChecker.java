package lotto;

import java.util.List;

public class LottoResultChecker {

    private final List<Integer> winningNumbers;


    public LottoResultChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
    }

    private int countMatchingNumbers(List<Integer> userNumbers) {
        int matchCount = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
