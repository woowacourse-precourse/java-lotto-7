package lotto;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
    private double totalProfit = .0;

    public void displayResults() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue;

            String resultLine = "";
            NumberFormat formatter = NumberFormat.getInstance();

            if (rank.hasBonus()) {
                resultLine = String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                        rank.getMatchCount(), formatter.format(rank.getPrize()), this.results.getOrDefault(rank, 0));
            } else {
                resultLine = String.format("%d개 일치 (%s원) - %d개",
                        rank.getMatchCount(), formatter.format(rank.getPrize()), this.results.getOrDefault(rank, 0));
            }
            System.out.println(resultLine);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", this.totalProfit);
    }

    public void calculateResults(List<LottoTicket> tickets, Lotto winningLotto, int bonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }

        for (LottoTicket ticket : tickets) {
            LottoRank rank = winningLotto.findRank(ticket);
            this.results.put(rank, this.results.get(rank) + 1);
        }

        calculateTotalProfit();
    }

    private void calculateTotalProfit() {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : results.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }

        int totalSpent = results.values().stream().mapToInt(count -> count * 1000).sum();

        totalProfit = (double) totalPrize / totalSpent * 100;
    }
}
