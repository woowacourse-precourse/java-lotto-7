package lotto.service;

import lotto.model.UserLotto;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class WinningService {
    public void matchLotto(List<List<Integer>> purchasedLotto, UserLotto userLotto) {
        List<Integer> matchingCounts = new ArrayList<>();
        List<Boolean> matchingBonus = new ArrayList<>();

        for (List<Integer> systemLotto : purchasedLotto) {
            List<Integer> matchingNumbers = new ArrayList<>(userLotto.getNumbers());
            matchingNumbers.retainAll(systemLotto);
            matchingCounts.add(matchingNumbers.size());

            boolean isContainBonus = systemLotto.contains(userLotto.getBonusNumber());
            matchingBonus.add(isContainBonus);
        }

        determineWinningRank(matchingCounts, matchingBonus);
    }

    private void determineWinningRank(List<Integer> matchingCounts, List<Boolean> matchingBonus) {
        for (int i = 0; i < matchingCounts.size(); i++) {
            WinningLotto winningLotto = winningResult(matchingCounts.get(i), matchingBonus.get(i));

            if (winningLotto != null) {
                winningLotto.incrementMatchCount();
            }
        }
    }

    private WinningLotto winningResult(int count, Boolean isBonusMatched) {
        if (count == 3) {
            return WinningLotto.THREE_MATCH;
        }
        if (count == 4) {
            return WinningLotto.FOUR_MATCH;
        }
        if (count == 5 && isBonusMatched) {
            return WinningLotto.FIVE_MATCH_BONUS;
        }
        if (count == 5) {
            return WinningLotto.FIVE_MATCH;
        }
        if (count == 6) {
            return WinningLotto.SIX_MATCH;
        }

        return null;
    }
}
