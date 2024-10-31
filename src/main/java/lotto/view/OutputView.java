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
            System.out.println(lotto.getNumbers().toString());
        });
    }

    public void printStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (!rank.equals(LottoRank.NONE)) {
                System.out.println(
                        makePrintMessage(rank, PrizeFormatter.formatPrize(rank.getPrize()),
                                statistics.get(rank)));
            }
        }
    }

    private String makePrintMessage(LottoRank rank, String prize, int count) {
        if (rank.equals(LottoRank.SECOND)) {
            return String.format(rank.getMatchingCount() + "개 일치, 보너스 볼 일치 " + "(" + prize + "원)"
                    + " - " + count
                    + "개");
        }
        return String.format(rank.getMatchingCount()  + "개 일치 " + "(" + prize + "원)"
                + " - " + count
                + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
