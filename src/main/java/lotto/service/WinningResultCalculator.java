package lotto.service;

import lotto.Lotto;
import lotto.enums.Rank;

import java.util.List;

public class WinningResultCalculator {

    public static Rank calculateResult(final Lotto userLotto, final List<Integer> winningNumbers, final int bonusNumber) {
        final int matchCount = countMatches(userLotto.getNumbers(), winningNumbers);
        final boolean matchBonus = userLotto.getNumbers().contains(bonusNumber);

        return Rank.getRank(matchCount, matchBonus);
    }

    private static int countMatches(final List<Integer> userNumbers, final List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
