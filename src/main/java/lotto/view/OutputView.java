package lotto.view;

import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoCounter;
import lotto.service.ProfitCalculator;

import java.util.List;

public class OutputView {

    public static void displayPurchasedLottos(int purchaseCount, List<Lotto> lottos) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void displayResults(LottoCounter rankCounter, int totalInvestment) {
        System.out.println(LottoConstants.RESULTS_HEADER);
        System.out.println(LottoConstants.DIVIDER);

        for (LottoRank rank : LottoRank.getRanksInAscendingOrder()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                        rank.getMatchCount(),
                        rank.getMatchBonus() ? ", 보너스 볼 일치" : "",
                        rank.getPrize(),
                        rankCounter.getMatchCount(rank));
            }
        }

        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profitRate = Math.round(profitCalculator.calculateProfitRate(rankCounter, totalInvestment) * 10) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}