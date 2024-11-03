package lotto.model;

import lotto.domain.Lotto;

public class LottoMatchCalculator {

    public static int countMatchedNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) winningNumbers.getNumbers().stream()
            .filter(number -> lotto.getNumbers().contains(number))
            .count();
    }

    public static boolean isBonusMatched(Lotto lotto, int matchCount, int bonusNumber) {
        return matchCount == 5 && lotto.getNumbers().contains(bonusNumber);
    }
}
