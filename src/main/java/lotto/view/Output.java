package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.winning.Rank;

public class Output {

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket);
    }

    public void printWinningStatistics(Map<Rank, Integer> lottoResult) {
        print("\n당첨 통계");
        print("---");

        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> printRankStatistics(rank, lottoResult));
    }

    private void printRankStatistics(Rank rank, Map<Rank, Integer> lottoResult) {
        int count = lottoResult.getOrDefault(rank, 0);
        print(rank.formatWinningStatistics(count));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public void print(String value) {
        System.out.println(value);
    }
}
