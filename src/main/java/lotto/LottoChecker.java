package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoChecker {

    public static Rank check(List<Integer> userNumbers, WinningNumbers winningNumbers) {
        Set<Integer> winningSet = new HashSet<>(winningNumbers.getWinningNumbers());

        int matchCount = 0;
        for (Integer number : userNumbers) {
            if (winningSet.contains(number)) {
                matchCount++;
            }
        }

        boolean matchBonus = userNumbers.contains(winningNumbers.getBonusNumber());

        return Rank.getRank(matchCount, matchBonus);
    }
}