package lotto.lotto;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<LottoWinning, Integer> winningCounts;

    public LottoResult() {
        winningCounts = new EnumMap<>(LottoWinning.class);
        for (LottoWinning winning : LottoWinning.values()) {
            winningCounts.put(winning, 0);
        }
    }

    public void incrementCount(LottoWinning winning) {
        winningCounts.put(winning, winningCounts.get(winning) + 1);
    }

    public int getCount(LottoWinning winning) {
        return winningCounts.get(winning);
    }

    public EnumMap<LottoWinning, Integer> getWinningCounts() {
        return winningCounts;
    }
}
