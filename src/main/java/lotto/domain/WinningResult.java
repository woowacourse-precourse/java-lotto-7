package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int COUNT = 1;

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

    public void increaseCountOf(Prize prize) {
        prizes.put(prize, prizes.get(prize) + COUNT);
    }
}
