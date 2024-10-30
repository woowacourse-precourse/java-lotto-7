package lotto.io.output.impl;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import lotto.io.output.GameOutput;

public class OutputConsole implements GameOutput {

    @Override
    public void printPurchasedTickets(LottoTicket lottoTicket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicket.size());
        lottoTicket.getTickets().forEach(System.out::println);
    }

    @Override
    public void printResults(Result result, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoRank> ranks = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND,
                LottoRank.FIRST);
        for (LottoRank rank : ranks) {
            int count = result.getMatchResults().getOrDefault(rank, 0);
            System.out.printf("%d개 일치%s (%s원) - %d개%n",
                    rank.getMatchCount(),
                    rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "",
                    rank.getPrize(),
                    count);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
