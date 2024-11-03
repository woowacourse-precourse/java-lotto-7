package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIALIZATION_VALUE = 0;
    private static final int INCREMENT_VALUE = 1;
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;
    private static final int SCALE_ONE = 1;

    private final Map<Rank, Integer> winningResults = new EnumMap<>(Rank.class);
    private double returnOnInvestment;

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            winningResults.put(rank, INITIALIZATION_VALUE);
        }
    }

    public void addResult(Rank rank) {
        winningResults.computeIfPresent(rank, (key, value) -> value + INCREMENT_VALUE);
    }

    public Map<Rank, Integer> getWinningResults() {
        return Collections.unmodifiableMap(winningResults);
    }

    public void calculateReturnOnInvestment(int purchaseAmount) {
        int totalPrizeMoney = winningResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        this.returnOnInvestment = BigDecimal.valueOf(((double) totalPrizeMoney / purchaseAmount) * PERCENTAGE_CONVERSION_FACTOR)
                .setScale(SCALE_ONE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getReturnOnInvestment() {
        return returnOnInvestment;
    }
}
