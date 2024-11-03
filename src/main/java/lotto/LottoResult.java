package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(Set<Integer> winningNumbers, int bonusNumber, List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            Rank rank = determineRank(ticket, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank determineRank(Lotto ticket, Set<Integer> winningNumbers, int bonusNumber) {
        int matchCount = ticket.countMatchingNumbers(winningNumbers);
        boolean bonusMatch = ticket.containsBonusNumber(bonusNumber);
        return Rank.getRank(matchCount, bonusMatch);
    }

    public void printResults() {
        System.out.println("당첨 통계\n---");
        rankCount.forEach((rank, count) -> System.out.printf("%s - %d개%n", rank, count));
    }

    public int getRankCount(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }
}
