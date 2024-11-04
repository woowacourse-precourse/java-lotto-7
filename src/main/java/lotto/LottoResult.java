package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();
    private int totalPrize = 0;
    private int purchaseAmount;

    // 생성자: 로또 구매 금액을 전달받습니다.
    public LottoResult(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    // 당첨 등수를 추가하고 총 상금을 계산하는 메서드
    public void addRank(LottoRank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        totalPrize += rank.getPrize();
    }

    // 당첨 등수와 개수를 반환하는 메서드
    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    // 수익률을 계산하는 메서드
    public double getYield() {
        if (purchaseAmount == 0) {
            return 0.0; // 구매 금액이 0이면 수익률은 0%
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}