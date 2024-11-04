package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoVerification {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<Rank, Integer> rankCounts = new HashMap<>();


    public LottoVerification(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        int totalPrize = 0;
        for(Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += entry.getValue() * entry.getKey().getPrize();
        }
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    public void calculateRank(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            Rank rank = Rank.decideRank(getMatchNumberCount(lotto), getMatchBonusNumber(lotto));
            if (rank == Rank.MISS) {
                continue;
            }
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private int getMatchNumberCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private boolean getMatchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
