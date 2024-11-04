package lotto.model;
import lotto.dto.LottoStatisticDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic implements LottoStatistics {
    private double yield;
    private final int amount;
    private final int quantity;
    private final int[] matchCounts = new int[LottoMatchEnum.values().length];

    public LottoStatistic(int purchaseAmount, int quantity) {
        this.amount = purchaseAmount;
        this.quantity = quantity;
        this.yield = 0.0;
    }

    public LottoStatisticDTO toDTO() {
        return new LottoStatisticDTO(getStatistics(), yield, amount, quantity);
    }

    public void updateLottoYield() {
        calculateLottoYield();
    }

    public void updateStatistics(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        compareLotteries(randomLotteries, userLotto, bonusNumber);
    }

    private  void compareLotteries(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        for (Lotto lotto : randomLotteries) {
            int matchCount = countMatchingNumbers(lotto.numbers(), userLotto);
            boolean bonusMatch = lotto.numbers().contains(bonusNumber);

            LottoMatchEnum category = LottoMatchEnum.getCategory(matchCount, bonusMatch);
            if (category != null) {
                increment(category);
            }
        }
    }

    private void increment(LottoMatchEnum category) {
        matchCounts[category.ordinal()]++;
    }

    private double calculateTotalEarnings() {
        double total = 0.0;
        for (LottoMatchEnum match : LottoMatchEnum.values()) {
            total += matchCounts[match.ordinal()] * match.getPrize();
        }
        return total;
    }

    private void calculateLottoYield() {
        double totalEarnings = calculateTotalEarnings();
        yield = totalEarnings > 0 ? Math.round((totalEarnings / amount) * 10000.0) / 100.0 : 0.0;
    }

    private int countMatchingNumbers(List<Integer> randomLotteries, Lotto userLotto) {
        int count = 0;
        for (Integer number : randomLotteries) {
            if (userLotto.numbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private Map<String, Integer> getStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        for (LottoMatchEnum match : LottoMatchEnum.values()) {
            statistics.put(match.getDisplayName(), matchCounts[match.ordinal()]);
        }
        return statistics;
    }
}
