package lotto.service;

import lotto.Lotto;
import lotto.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputService {
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningStatistics(Map<LottoRank, Integer> winningCountForEach) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : winningCountForEach.keySet()) {
            String description = rank.getDescription();
            String formattedPrize = formatPrize(rank);
            int winningCount = winningCountForEach.get(rank);

            System.out.print(description + formattedPrize);
            System.out.println(" - " + winningCount + "개");
        }
    }

    public String formatPrize(LottoRank rank) {
        long prize = rank.getPrize();
        return String.format(" (%,d원)", prize);
    }
}
