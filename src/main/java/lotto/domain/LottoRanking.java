package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRanking {
    public Map<String, Integer> calculateRank(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> result = initResult();

        for (Lotto lotto : issuedLottos) {
            updateResult(result, lotto, winningNumbers, bonusNumber);
        }
        return result;
    }

    private Map<String, Integer> initResult() {
        Map<String, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank.getDescription(), 0);
        }
        return result;
    }

    private void updateResult(Map<String, Integer> result, Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchedCount = matchCount(lotto.getNumbers(), winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        String rankDescription = getRankDescription(matchedCount, hasBonus);
        if(rankDescription!=null) {
            result.put(rankDescription, result.get(rankDescription) + 1);
        }
    }

    private int matchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private String getRankDescription(int matchedCount, boolean hasBonus) {
        if (matchedCount == 6) {
            return Rank.SIX.getDescription();
        }
        if (matchedCount == 5 && hasBonus) {
            return Rank.BONUS.getDescription();
        }

        if (matchedCount == 5) {
            return Rank.FIVE.getDescription();
        }
        if (matchedCount == 4) {
            return Rank.FOUR.getDescription();
        }
        if (matchedCount == 3) {
            return Rank.THREE.getDescription();
        }
        return null;
    }


}
