package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {
    public static void printLottoTicket(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(numbers);
        }
    }

    public static void printWinningStatistics(int[] rankCounts, double earningRate) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCounts[LottoRank.ranks.indexOf(LottoRank.FIFTH)] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts[LottoRank.ranks.indexOf(LottoRank.FOURTH)] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts[LottoRank.ranks.indexOf(LottoRank.THIRD)] + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts[LottoRank.ranks.indexOf(LottoRank.SECOND)] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts[LottoRank.ranks.indexOf(LottoRank.FIRST)] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}
