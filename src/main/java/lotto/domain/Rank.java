package lotto.domain;

import java.util.List;
import lotto.prizelotto.FirstPrizeLotto;
import lotto.prizelotto.SecondPrizeLotto;

public class Rank {
    private FirstPrizeLotto firstPrizeLotto;
    private SecondPrizeLotto secondPrizeLotto;

    public void countMatchNumber(List<Integer> numbers, WinNumbers winNumbers) {
        List<Integer> compareNumbers = winNumbers.primaryWinNumbers();
        int result = 0;
        for (Integer number : numbers) {
            if (compareNumbers.contains(number)) {
                result++;
            }
        }
    }

    private void decideRankNumber(int count, List<Integer> numbers, WinNumbers winNumbers) {
        if (count == 6) {
            firstPrizeLotto.of();
        }
        if (count == 5 && decideSecondThird(winNumbers.bonusWinNumber(), numbers)) {
            secondPrizeLotto.of();
        }
    }

    private boolean decideSecondThird(int bonusNumber, List<Integer> numbers) {
        return (numbers.contains(bonusNumber));
    }
}
