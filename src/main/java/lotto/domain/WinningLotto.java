package lotto.domain;


import java.util.HashSet;
import java.util.List;

import static lotto.domain.Validator.validateBonusNumber;
import static lotto.domain.Validator.validateUniqueNumbers;

public class WinningLotto {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateUniqueNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }


}
