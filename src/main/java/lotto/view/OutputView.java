package lotto.view;

import lotto.utility.MatchedCountNameEnum;
import lotto.utility.MatchedNumberEnum;

import java.math.BigDecimal;
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
        System.out.println(MatchedNumberEnum.THREE_MATCHED.getMessage() + " - " + matchedCount.get(MatchedCountNameEnum.THREE_MATCHED.getMessage()) + "개");
        System.out.println(MatchedNumberEnum.FOUR_MATCHED.getMessage() + " - " + matchedCount.get(MatchedCountNameEnum.FOUR_MATCHED.getMessage()) + "개");
        System.out.println(MatchedNumberEnum.FIVE_MATCHED.getMessage() + " - " + matchedCount.get(MatchedCountNameEnum.FIVE_MATCHED.getMessage()) + "개");
        System.out.println(MatchedNumberEnum.FIVE_WITH_BONUS_MATCHED.getMessage() + " - " + matchedCount.get(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage()) + "개");
        System.out.println(MatchedNumberEnum.SIX_MATCHED.getMessage() + " - " + matchedCount.get(MatchedCountNameEnum.SIX_MATCHED.getMessage()) + "개");
    }

    public static void outputProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
