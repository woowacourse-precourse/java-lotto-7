package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void purchaseLottos(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.generateRandomLotto();
            purchasedLottos.add(lotto);
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> calculateRankCounts() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = lotto.containsBonus(bonusNumber);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            if (rank != null) {
                rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
            }
        }
        return rankCounts;
    }

    public long calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculateProfitRate(long totalPrize) {
        if (purchasedLottos.isEmpty()) {
            return 0.0;
        }
        return (double) totalPrize / (purchasedLottos.size() * 1000) * 100;
    }
}
