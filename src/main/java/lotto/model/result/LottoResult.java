package lotto.model.result;

import lotto.model.lotto.Lotto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRank(lotto.getMatchCount(winningNumbers), lotto.contains(bonusNumber));
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    // 당첨 등수별 개수를 가져오는 메서드
    public int getRankCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    // 총 당첨 금액을 계산하는 메서드
    public int getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    // 등수별 당첨 결과를 반환하는 메서드
    public Map<Rank, Integer> getRankResults() {
        return Collections.unmodifiableMap(rankCounts);
    }

}
