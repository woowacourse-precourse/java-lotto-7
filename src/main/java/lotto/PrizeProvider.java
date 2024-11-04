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

    public double calculateRateOfReturn(final int purchaseAmount) {
        final long totalWinningMoney = calculateTotalWinningMoney();
        return (double) totalWinningMoney / purchaseAmount * 100;
    }

    private long calculateTotalWinningMoney() {
        Map<WinningRank, Long> ranks = getCountedWinningRanks();
        return ranks.entrySet().stream()
                .mapToLong(rank -> rank.getKey().getMoney() * rank.getValue())
                .sum();
    }
}
