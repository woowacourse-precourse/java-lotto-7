package lotto.view;

import lotto.model.Lotto;
import lotto.model.type.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputHandler {
    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
    public void printStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(LottoRank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(LottoRank.FIRST) + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
