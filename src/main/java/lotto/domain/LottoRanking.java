package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRanking {

    public Map<Integer, Integer> calculateRank(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> result = initResult();

        for (Lotto lotto : issuedLottos) {
            updateResult(result, lotto, winningNumbers, bonusNumber);
        }
        return result;
    }

    private Map<Integer, Integer> initResult() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank.getWinningMoney(), 0);
        }
        return result;
    }

    private void updateResult(Map<Integer, Integer> result, Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchedCount = matchCount(lotto.getNumbers(), winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        int winningMoney = getWinningMoney(matchedCount, hasBonus);
        if(winningMoney!=0) {
            result.put(winningMoney, result.get(winningMoney) + 1);
        }
    }

    private int matchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        int matchedCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    private Integer getWinningMoney(int matchedCount, boolean hasBonus) {
        if (matchedCount == 6) {
            return Rank.SIX.getWinningMoney();
        }
        if (matchedCount == 5 && hasBonus) {
            return Rank.BONUS.getWinningMoney();
        }

        if (matchedCount == 5) {
            return Rank.FIVE.getWinningMoney();
        }
        if (matchedCount == 4) {
            return Rank.FOUR.getWinningMoney();
        }
        if (matchedCount == 3) {
            return Rank.THREE.getWinningMoney();
        }
        return 0;
    }


}
