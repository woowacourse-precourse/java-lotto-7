package lotto.model.result;

import lotto.model.lotto.Lotto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class LottoResult {
    private static final Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRank(lotto.getMatchCount(winningNumbers), lotto.contains(bonusNumber));
            if (rank != null) {
                rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
            }
        }
    }

    // 총 당첨 금액을 계산하는 메서드
    public static int getTotalPrize() {
        return rankCounts.entrySet().stream()
                            .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                            .sum();
    }

    // 등수별 당첨 결과를 반환하는 메서드
    public Map<Rank, Integer> getRankResults() {
        return Collections.unmodifiableMap(rankCounts);
    }

    // 수익률을 계산하는 메서드
    public double getProfitRate(int totalPrizeAmount, int PurchaseAmount){
        return ((double) totalPrizeAmount / PurchaseAmount) * 100;
    }



}
