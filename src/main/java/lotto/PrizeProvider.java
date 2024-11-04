package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeProvider {

    private final List<WinningStatus> winningStatuses;

    public PrizeProvider(final List<WinningStatus> winningStatuses) {
        this.winningStatuses = winningStatuses;
    }

    public Map<WinningRank, Long> getPrizes() {
        Map<WinningRank, Long> ranks = new EnumMap<>(WinningRank.class);
        for (WinningRank rank : WinningRank.values()) {
            ranks.put(rank, 0L);
        }
        ranks.putAll(getCountedWinningRanks());

        return ranks;
    }

    private Map<WinningRank, Long> getCountedWinningRanks() {
        return winningStatuses.stream()
                .collect(
                        Collectors.groupingBy(
                                WinningStatus::getWinningRank,
                                Collectors.counting()
                        )
                );
    }
}
