package lotto.view;

import java.util.Map;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

public class Output {

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.getSize() + "개를 구매했습니다.");
        System.out.println(lottoTicket);
    }

    public void printLottoStatistics(Map<Rank, Integer> lottoResult) {
        System.out.println("\n" + "당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            int count = lottoResult.getOrDefault(rank, 0);
            System.out.println(rank.formatWinningStatistics(count));
        }
    }
}
