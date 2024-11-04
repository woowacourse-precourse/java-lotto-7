package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void plusCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return rankCounts.get(rank);
    }

    public void calculateResults(List<List<Integer>> lottos, Lotto winningLotto, int bonusNumber) {
        for (List<Integer> lotto : lottos) {
            int matchCount = countMatches(lotto, winningLotto.getNumbers());

            if (matchCount == 3) {
                plusCount(LottoRank.FIFTH);
            } else if (matchCount == 4) {
                plusCount(LottoRank.FOURTH);
            } else if (matchCount == 5) {
                plusCount(LottoRank.THIRD);
            } else if (matchCount == 5 && lotto.contains(bonusNumber)) {
                plusCount(LottoRank.SECOND);
            } else if (matchCount == 6) {
                plusCount(LottoRank.FIRST);
            }
        }
    }

    private int countMatches(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}