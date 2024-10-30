package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.Lotto;
import lotto.util.PrizeFormatter;

public class OutputView {
    public void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.println(purchasedLotto.size() + "개를 구매했습니다.");
        purchasedLotto.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public void printStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (!rank.equals(LottoRank.NONE)) {
                System.out.println(
                        rank.getMatchingCount() + "개 일치 " + "(" + PrizeFormatter.formatPrize(rank.getPrize()) + "원)"
                                + " - " + statistics.get(rank)
                                + "개");
            }
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
