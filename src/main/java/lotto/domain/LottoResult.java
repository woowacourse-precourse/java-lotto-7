package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<WinningPrize, Integer> results;

    public LottoResult() {
        results = new EnumMap<>(WinningPrize.class);
        initializeResults();
    }

    private void initializeResults() {
        for (WinningPrize winningPrize : WinningPrize.values()) {
            if (winningPrize != WinningPrize.NONE_PRIZE) {
                results.put(winningPrize, 0);
            }
        }
    }

}