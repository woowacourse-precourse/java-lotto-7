package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoWinningChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getWinningGrade(Lotto lotto) {
        int winningMatched = 0;

        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                winningMatched++;
            }
        }

        return findRankByMatched(lotto, winningMatched);
    }

    private int findRankByMatched(Lotto lotto, int winningMatched) {
        if (winningMatched == 6) {
            return 1;
        }
        if (winningMatched == 5 && lotto.contains(bonusNumber)) {
            return 2;
        }
        if (winningMatched == 5) {
            return 3;
        }
        if (winningMatched == 4) {
            return 4;
        }
        if (winningMatched == 3) {
            return 5;
        }
        return 6;
    }
}
