package lotto.domain.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.global.common.Rank;

public final class Statistics {

    private final Lotteries lotteries;
    private final Map<Rank, Integer> resultCountMap;

    private Statistics(Lotteries lotteries, Lotto winningLotto, int bonusNumber) {
        this.lotteries = lotteries;
        this.resultCountMap = countRanks(checkLotteries(winningLotto, bonusNumber));
    }

    public static Statistics of(Lotteries lotteries, Lotto winningLotto, int bonusNumber) {
        return new Statistics(lotteries, winningLotto, bonusNumber);
    }

    public double calculateProfitRate() {
        final double seed = Lotto.TICKET_PRICE * lotteries.size();
        int profit = 0;

        for (Entry<Rank, Integer> entry : resultCountMap.entrySet()){
            profit += entry.getKey().price * entry.getValue();
        }

        return profit / seed * 100;
    }

    private Map<Rank, Integer> countRanks(List<Rank> ranks) {
        Map<Rank, Integer> statistics = new HashMap<>();

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Rank rank : ranks) {
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }

        return statistics;
    }

    private List<Rank> checkLotteries(Lotto winningLotto, int bonus) {
        return lotteries.getLotteries()
                .stream()
                .map(ticket -> ticket.check(winningLotto, bonus))
                .toList();
    }

    @Override
    public String toString() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .map(rank -> String.format("%s - %d개", rank, resultCountMap.get(rank)))
                .collect(Collectors.joining("\n"));
    }
}
