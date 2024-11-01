package lotto.model;

import lotto.dto.LottoStatisticDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic implements LottoStatistics {
    private Map<String, Integer> statistics;
    private double yield;
    private int amount;
    private int quantity;

    public LottoStatistic(int purchaseAmount, int quantity) {
        statistics = new HashMap<>();
        statistics.put("3개 일치 (5,000원)", 0);
        statistics.put("4개 일치 (50,000원)", 0);
        statistics.put("5개 일치 (1,500,000원)", 0);
        statistics.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        statistics.put("6개 일치 (2,000,000,000원)", 0);
        yield = 0.0;
        this.amount = purchaseAmount;
        this.quantity = quantity;
    }

    private void increment(String key) {
        statistics.put(key, statistics.get(key) + 1);
    }

    public LottoStatisticDTO toDTO() {
        return new LottoStatisticDTO(Map.copyOf(statistics), yield, amount, quantity);
    }

    public void updateLottoYield() {
        calculateLottoYield();
    }

    public void updateStatistics(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        calculateStatistics(randomLotteries, userLotto, bonusNumber);
    }

    private double calculateTotalEarnings() {
        double total = 0.0;
        total += statistics.get("3개 일치 (5,000원)") * 5000;
        total += statistics.get("4개 일치 (50,000원)") * 50000;
        total += statistics.get("5개 일치 (1,500,000원)") * 1500000;
        total += statistics.get("5개 일치, 보너스 볼 일치 (30,000,000원)") * 30000000;
        total += statistics.get("6개 일치 (2,000,000,000원)") * 2000000000;
        return total;
    }

    private void calculateLottoYield() {
        double totalEarnings = calculateTotalEarnings();
        double yield = (totalEarnings / amount) * 100;
        this.yield = Math.round(yield * 100.0) / 100.0;
    }

    private void calculateStatistics(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        for (Lotto lotto : randomLotteries) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), userLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                this.increment("6개 일치 (2,000,000,000원)");
            } else if (matchCount == 5 && bonusMatch) {
                this.increment("5개 일치, 보너스 볼 일치 (30,000,000원)");
            } else if (matchCount == 5) {
                this.increment("5개 일치 (1,500,000원)");
            } else if (matchCount == 4) {
                this.increment("4개 일치 (50,000원)");
            } else if (matchCount == 3) {
                this.increment("3개 일치 (5,000원)");
            }
        }
    }

    private int countMatchingNumbers(List<Integer> randomLotteries, Lotto userLotto) {
        int count = 0;
        for (Integer number : randomLotteries) {
            if (userLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }


}