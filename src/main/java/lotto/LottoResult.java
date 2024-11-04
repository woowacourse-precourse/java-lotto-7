package lotto;

import static lotto.LottoMachine.PRICE_PER_LOTTO;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> results;

    public void printResult(List<Lotto> tickets, WinningNumber winningNumber) {
        results = calculateResults(tickets, winningNumber);
        printWinningStatistics();
        printProfitRate(tickets.size());
    }

    private Map<LottoRank, Integer> calculateResults(List<Lotto> tickets, WinningNumber winningNumber) {
        Map<LottoRank, Integer> rankCounts = initializeResults();
        for (Lotto ticket : tickets) {
            updateResult(rankCounts, ticket, winningNumber);
        }
        return rankCounts;
    }

    private Map<LottoRank, Integer> initializeResults() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void updateResult(Map<LottoRank, Integer> rankCounts, Lotto ticket, WinningNumber winningNumber) {
        int matchCount = countMatches(ticket, winningNumber.getNumbers());
        boolean bonusMatch = ticket.contains(winningNumber.getBonusNumber());
        LottoRank rank = LottoRank.getLottoRank(matchCount, bonusMatch);
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    private int countMatches(Lotto ticket, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            if (ticket.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void printWinningStatistics() {
        System.out.println("\n당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s (%,d원) - %d개\n",
                        rank.getDescription(),
                        rank.getPrize(),
                        results.get(rank));
            }
        }
    }

    private void printProfitRate(int ticketCount) {
        double profitRate = calculateProfitRate(ticketCount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    double calculateProfitRate(int ticketCount) {
        long totalPrize = calculateTotalPrize();
        int totalAmount = ticketCount * PRICE_PER_LOTTO;
        return (double) totalPrize / totalAmount * 100;
    }

    private long calculateTotalPrize() {
        long sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += (long) rank.getPrize() * results.get(rank);
        }
        return sum;
    }
}
