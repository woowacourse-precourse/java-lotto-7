package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIALIZATION_VALUE = 0;
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;

    private final Map<Rank, Integer> winningResults = new EnumMap<>(Rank.class);

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            winningResults.put(rank, INITIALIZATION_VALUE);
        }
    }

    public void addResult(Rank rank) {
        winningResults.put(rank, winningResults.get(rank) + 1);
    }

    public Map<Rank, Integer> getWinningResults() {
        return new EnumMap<>(winningResults);
    }

    public double calculateReturnOnInvestment(int purchaseAmount) {
        int totalPrizeMoney = winningResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return ((double) totalPrizeMoney / purchaseAmount) * PERCENTAGE_CONVERSION_FACTOR;
    }
}
