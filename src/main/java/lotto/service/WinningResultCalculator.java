package lotto.service;

import lotto.Lotto;
import lotto.enums.Rank;

import java.util.List;

public class WinningResultCalculator {

    public static Rank calculateResult(Lotto userLotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatches(userLotto.getNumbers(), winningNumbers);
        boolean matchBonus = userLotto.getNumbers().contains(bonusNumber);

        return Rank.getRank(matchCount, matchBonus);
    }

    private static int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
