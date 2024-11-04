package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {

    private static final int DEFAULT_VALUE = 0;

    private final Map<Prize, Integer> prizes;

    private WinningResult(Map<Prize, Integer> prizes) {
        this.prizes = prizes;
    }

    public static WinningResult create() {
        Map<Prize, Integer> winningPrizes = new LinkedHashMap<>();
        Arrays.stream(Prize.values()).forEach(
                prize -> winningPrizes.put(prize, DEFAULT_VALUE)
        );

        return new WinningResult(winningPrizes);
    }
}
