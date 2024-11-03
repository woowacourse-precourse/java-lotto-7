package lotto.view;

import lotto.utility.LottoPrizeEnum;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void outputPurchasedLottoCount(int purchasedLottoCount) {
        System.out.println();
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseOneLottoResult(List<Integer> purchasedLottoNumbers) {
        Collections.sort(purchasedLottoNumbers);
        System.out.println(purchasedLottoNumbers);
    }

    public static void outputMatchedCount(Map<String, Integer> matchedCount) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.println(LottoPrizeEnum.THREE_MATCHED.getMessage() + " - " + matchedCount.get("threeMatched") + "개");
        System.out.println(LottoPrizeEnum.FOUR_MATCHED.getMessage() + " - " + matchedCount.get("fourMatched") + "개");
        System.out.println(LottoPrizeEnum.FIVE_MATCHED.getMessage() + " - " + matchedCount.get("fiveMatched") + "개");
        System.out.println(LottoPrizeEnum.FIVE_WITH_BONUS_MATCHED.getMessage() + " - " + matchedCount.get("fiveWithBonusMatched") + "개");
        System.out.println(LottoPrizeEnum.SIX_MATCHED.getMessage() + " - " + matchedCount.get("sixMatched") + "개");
    }

    public static void outputProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
