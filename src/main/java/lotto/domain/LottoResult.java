package lotto.domain;

import java.util.Map;
import java.util.EnumMap;
import lotto.constant.Rank;

import static lotto.constant.LottoConstants.PRICE_PER_LOTTO;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT = 1;
    private static final long INITIAL_WINNINGS = 0L;
    private static final int PERCENT_CONVERSION_FACTOR = 100;


    private final Map<Rank, Integer> winningCount = new EnumMap<>(Rank.class);
    private long totalWinnings = 0;
    private long totalWinnings = INITIAL_WINNINGS;

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            winningCount.put(rank, 0);
        }
    }

    public void recordMatch(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + INCREMENT);
        totalWinnings += rank.getWinnings();
    }

    public Map<Rank, Integer> getWinningCount() {
        return winningCount;
    }

    public long getTotalWinnings() {
        return totalWinnings;
    }
}
