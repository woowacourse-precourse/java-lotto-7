package lotto;

import java.util.Map;

public class OutputUtils {
    public static void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.getSize() + "개를 구매했습니다.");
        purchasedLotto.printPurchasedLotto();
    }

    public static void printLottoResult(LotteryRoundManager lotteryManager, PurchasedLotto purchasedLotto) {
        Map<Prize, Integer> prizeResult = lotteryManager.checkWon(purchasedLotto);
        System.out.println("3개 일치 (5,000원) - " + prizeResult.getOrDefault(Prize.FIFTH_PLACE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeResult.getOrDefault(Prize.FOURTH_PLACE, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeResult.getOrDefault(Prize.THIRD_PLACE, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeResult.getOrDefault(Prize.SECOND_PLACE, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeResult.getOrDefault(Prize.FIRST_PLACE, 0) + "개");
        System.out.println("총 수익률은 " + lotteryManager.calculateBenefit(prizeResult) + "%입니다.");
    }
}
