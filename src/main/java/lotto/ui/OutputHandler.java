package lotto.ui;

import lotto.domain.LottoTickets;
import lotto.domain.WinningResult;
import lotto.enums.Rank;

public class OutputHandler {
    private static final int MINIMUM_MATCH_COUNT_FOR_RANK = 3;

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf(System.lineSeparator() + "%d개를 구매했습니다.%n", lottoTickets.size());

        lottoTickets.getLottoTickets().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public static void printWinningStatistics(WinningResult winningResult, double profitRate) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---");
        printRankResults(winningResult);
        printProfitRate(profitRate);
    }

    private static void printRankResults(WinningResult winningResult) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                printSecondRankResult(winningResult);
            } else if (rank.getMatchCount() >= MINIMUM_MATCH_COUNT_FOR_RANK) {
                printOtherRankResult(rank, winningResult);
            }
        }
    }

    private static void printSecondRankResult(WinningResult winningResult) {
        System.out.printf(
                "5개 일치, 보너스 볼 일치 (%d원) - %d개%n",
                Rank.SECOND.getPrize(),
                winningResult.getRankCount(Rank.SECOND)
        );
    }

    private static void printOtherRankResult(Rank rank, WinningResult winningResult) {
        System.out.printf(
                "%d개 일치 (%d원) - %d개%n",
                rank.getMatchCount(),
                rank.getPrize(),
                winningResult.getRankCount(rank)
        );
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
