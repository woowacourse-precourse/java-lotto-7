package lotto.io.output.impl;

import java.util.List;
import lotto.LottoRank;
import lotto.LottoTicket;
import lotto.Result;
import lotto.io.output.GameOutput;

public class OutputConsole implements GameOutput {

    @Override
    public void printPurchasedTickets(LottoTicket lottoTicket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicket.size());
        lottoTicket.getTickets().forEach(System.out::println);
    }

    @Override
    public void printResults(Result result, int totalPrice) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoRank> ranks = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND,
                LottoRank.FIRST);
        for (LottoRank rank : ranks) {
            int count = result.getMatchResults().get(rank);
            System.out.printf("%d개 일치%s (%s원) - %d개%n",
                    rank.getMatchCount(),
                    rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "",
                    rank.getPrize(),
                    count);
        }

        double yield = result.calculateYield(totalPrice);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(yield * 10) / 10.0);
    }
}
