package lotto;

import java.util.List;

public class WinningResult {
    private final List<Lotto> tickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int[] matchCounts = new int[LottoRank.values().length];

    public WinningResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        calculateResults();
    }

    // 각 로또 티켓의 당첨 결과를 계산
    private void calculateResults() {
        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            matchCounts[rank.ordinal()]++;
        }
    }

    // 당첨 내역을 출력
    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치 (%d원) - %d개%n",
                        rank.getMatchCount(), rank.getPrize(), matchCounts[rank.ordinal()]);
            }
        }

        double totalPrize = calculateTotalPrize();
        double purchaseAmount = tickets.size() * 1000;
        double profitRate = (totalPrize / purchaseAmount) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    // 총 당첨 금액 계산
    private double calculateTotalPrize() {
        double totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += matchCounts[rank.ordinal()] * rank.getPrize();
        }
        return totalPrize;
    }
}
