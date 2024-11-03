package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;

import java.util.List;

public class OutputView {
    public static void printPurchaseAmount(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getMoney() / PurchaseAmount.LOTTE_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getCount(Rank.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoResult.calculateYield());
    }
}
