package lotto.model;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class MatchingResult {

    private static final int LOTTO_PRICE = 1000;

    private final Map<Rank, Integer> matchingResult = new LinkedHashMap<>();
    private final int quantity;

    public MatchingResult(int quantity) {
        this.quantity = quantity;
        for (Rank rank : Rank.values()) {
            matchingResult.put(rank, 0);
        }
    }

    public void incrementsSingleMatchCount(Rank rank) {
        matchingResult.put(rank, matchingResult.get(rank) + 1);
    }

    public double calculateEarningsRate() {
        long earnings = calculateEarnings();
        return 100.0 * ((double) earnings / (this.quantity * LOTTO_PRICE));
    }

    private long calculateEarnings() {
        return matchingResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        matchingResult.forEach((rank, count) -> {
            result.append(String.format(rank.toString() + " - %d개\n", count));
        });
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        result.append(String.format("총 수익률은 %s%%입니다.\n", decimalFormat.format(calculateEarningsRate())));
        return result.toString();
    }
}
