package lotto;

import java.util.EnumMap;

public class StatisticalMachine {

    private final EnumMap<WinningRank, Integer> statistics;

    public StatisticalMachine() {
        statistics = new EnumMap<>(WinningRank.class);

        for (WinningRank rank : WinningRank.values()) {
            statistics.put(rank, 0);
        }
    }

}
