package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.enumtype.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            List<Integer> numbers = ticket.getLotto().getNumbers();
            System.out.println(numbers);
        }
    }

    public static void printStatistics(List<LottoTicket> tickets, WinningLotto winningLotto, int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        Map<Rank, Integer> statistics = calculateStatistics(tickets, winningLotto);
        printRankStatistics(statistics);
        printYield(statistics, purchaseAmount);
    }

    private static Map<Rank, Integer> calculateStatistics(List<LottoTicket> tickets, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> statistics.put(rank, 0));

        for (LottoTicket ticket : tickets) {
            Rank rank = winningLotto.match(ticket);
            if (rank != Rank.MISS) {
                statistics.put(rank, statistics.get(rank) + 1);
            }
        }
        return statistics;
    }

    private static void printRankStatistics(Map<Rank, Integer> statistics) {
        List<Rank> orderedRanks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        orderedRanks.forEach(rank -> {
            String message = rank.getMatchCount() + "개 일치";
            if (rank == Rank.SECOND) {
                message += ", 보너스 볼 일치";
            }
            message += " (" + formatPrize(rank.getPrize()) + ") - " + statistics.get(rank) + "개";
            System.out.println(message);
        });
    }

    private static void printYield(Map<Rank, Integer> statistics, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(statistics);
        double yield = (double) totalPrize / purchaseAmount * 100;
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("총 수익률은 " + df.format(yield) + "%입니다.");
    }

    private static long calculateTotalPrize(Map<Rank, Integer> statistics) {
        long total = 0;
        for (Rank rank : Rank.values()) {
            total += (long) rank.getPrize() * statistics.get(rank);
        }
        return total;
    }

    private static String formatPrize(int prize) {
        return String.format("%,d원", prize);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
