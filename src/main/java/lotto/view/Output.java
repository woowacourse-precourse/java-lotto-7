package lotto.view;

import java.util.Map;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.winning.Rank;

public class Output {

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket);
    }

    public void printLottoStatistics(Map<Rank, Integer> lottoResult) {
        print("\n" + "당첨 통계");
        print("---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            int count = lottoResult.getOrDefault(rank, 0);
            print(rank.formatWinningStatistics(count));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public void print(String value) {
        System.out.println(value);
    }
}
