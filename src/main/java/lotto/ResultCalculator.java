package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos, Lotto winningNumber, int bonus) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumber.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonus);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private int countMatches(List<Integer> lottos, List<Integer> winningNumber) {
        int count = 0;

        for (int number : lottos) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }

        return count;
    }
}
