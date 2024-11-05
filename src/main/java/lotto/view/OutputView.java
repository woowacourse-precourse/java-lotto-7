package lotto.view;

import lotto.enumerate.LottoPrizeEnum;
import lotto.enumerate.MatchedCountKeyEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void outputPurchasedLottoCount(int purchasedLottoCount) {
        System.out.println();
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseOneLottoResult(List<Integer> purchasedLottoNumbers) {
        List<Integer> mutableList = new ArrayList<>(purchasedLottoNumbers);
        Collections.sort(mutableList);
        System.out.println(mutableList);
    }

    public static void outputMatchedCount(Map<String, Integer> matchedCount) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.println(LottoPrizeEnum.THREE_MATCHED.getMessage() + " - "
                + matchedCount.get(MatchedCountKeyEnum.THREE_MATCHED.getKey()) + "개");
        System.out.println(LottoPrizeEnum.FOUR_MATCHED.getMessage() + " - "
                + matchedCount.get(MatchedCountKeyEnum.FOUR_MATCHED.getKey()) + "개");
        System.out.println(LottoPrizeEnum.FIVE_MATCHED.getMessage() + " - "
                + matchedCount.get(MatchedCountKeyEnum.FIVE_MATCHED.getKey()) + "개");
        System.out.println(LottoPrizeEnum.FIVE_WITH_BONUS_MATCHED.getMessage() + " - "
                + matchedCount.get(MatchedCountKeyEnum.FIVE_WITH_BONUS_MATCHED.getKey()) + "개");
        System.out.println(LottoPrizeEnum.SIX_MATCHED.getMessage() + " - "
                + matchedCount.get(MatchedCountKeyEnum.SIX_MATCHED.getKey()) + "개");
    }

    public static void outputProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
