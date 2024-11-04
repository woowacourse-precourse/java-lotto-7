package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class LottoOutputView {
    public void printTickets(List<Lotto> tickets) {
        System.out.println();
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
        System.out.println();
    }

    public void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<LottoRank, Integer> results = result.getResults();
        printRankResults(results);

        double yield = result.calculateYield(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private void printRankResults(Map<LottoRank, Integer> results) {
        LottoRank[] ranks = {
                LottoRank.FIFTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST
        };

        for (LottoRank rank : ranks) {
            String rankOutput = (rank == LottoRank.SECOND)
                    ? "5개 일치, 보너스 볼 일치"
                    : rank.getMatchCount() + "개 일치";
            System.out.println(rankOutput + " (" + rank.getPrize() + "원) - " + results.getOrDefault(rank, 0) + "개");
        }
    }
}