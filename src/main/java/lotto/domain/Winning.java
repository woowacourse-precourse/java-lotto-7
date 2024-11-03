package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Winning {

    private Map<Rank, Integer> winningCount;

    public Winning() {
        winningCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningCount.put(rank, 0);
        }
    }

    public void increaseWinningCount(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return winningCount.get(rank);
    }

    public List<Rank> getAllRanks() {
        EnumSet<Rank> rankWithoutLose = getRankWithoutLose();
        return sortRanks(rankWithoutLose);
    }

    public long getPrizeOfRank(Rank rank) {
        return (long) winningCount.get(rank) * rank.getPrize();
    }

    private EnumSet<Rank> getRankWithoutLose() {
        EnumSet<Rank> rankWithoutLose = EnumSet.allOf(Rank.class);
        rankWithoutLose.remove(Rank.RANK_LOSE);

        return rankWithoutLose;
    }

    private List<Rank> sortRanks(EnumSet<Rank> ranks) {
        return ranks.stream()
                .sorted(Comparator.comparingInt(Rank::ordinal))
                .collect(Collectors.toList());
    }

}
