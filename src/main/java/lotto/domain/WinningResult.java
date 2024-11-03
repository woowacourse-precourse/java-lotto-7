package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<WinningPrize, Integer> prizeCount;
    private final int totalCount;

    WinningResult(List<WinningPrize> prizes) {
        totalCount = prizes.size();
        prizeCount = new EnumMap<>(WinningPrize.class);
        for (WinningPrize prize : prizes) {
            prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
        }
    }

    public int get(WinningPrize prize) {
        return prizeCount.getOrDefault(prize, 0);
    }

    public double getTotalRate() {
        long totalPrice = calculateTotalPrice();

        return round(totalPrice / (double) (totalCount * Lotto.PRICE) * 100);
    }

    private long calculateTotalPrice() {
        long total = 0;
        for (Map.Entry<WinningPrize, Integer> entry : prizeCount.entrySet()) {
            total += entry.getKey().getPrizeMoney() * entry.getValue();
        }

        return total;
    }

    private double round(double cal) {
        return (double) Math.round(cal * 10) / 10;
    }
}