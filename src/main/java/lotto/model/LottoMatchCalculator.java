package lotto.model;

import lotto.domain.Lotto;

public class LottoMatchCalculator {
    public static final int MATCH_COUNT = 5;

    public static int countMatchedNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) winningNumbers.getNumbers().stream()
            .filter(number -> lotto.getNumbers().contains(number))
            .count();
    }

    public static boolean isBonusMatched(Lotto lotto, int matchCount, int bonusNumber) {
        return matchCount == MATCH_COUNT && lotto.getNumbers().contains(bonusNumber);
    }
}
