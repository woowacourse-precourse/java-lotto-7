package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private final List<Lotto> userLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultCalculator(List<Lotto> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> calculateStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
        for (Lotto lotto : userLottos) {
            int matchCount = calculateMatchCount(lotto);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, hasBonus);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    public int calculateTotalPrize(Map<Rank, Integer> statistics) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    public double calculateROI(int totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0;
        }
        double roi = (double) totalPrize / purchaseAmount * 100;
        return Math.round(roi * 10) / 10.0;
    }

    private int calculateMatchCount(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
