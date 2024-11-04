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
        System.out.printf("3개 일치 (5,000원) - %d개%n", getRankCount(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", getRankCount(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", getRankCount(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", getRankCount(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", getRankCount(Rank.FIRST));
    }

    public int getRankCount(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = (double) totalPrize / purchaseAmount * 100;

        return Math.round(profitRate * 100) / 100.0;
    }
}
