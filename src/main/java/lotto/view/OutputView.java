package lotto.view;

import lotto.LottoResult;
import lotto.controller.LottoPurchaseController;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;

public class OutputView {

    public static void showPurchasedLottoCount(long purchasedLottoCount) {
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public static void showPurchasedLottos(Lottos lottos) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            String printLotto = lotto.printLotto();
            stringBuilder.append(printLotto + "\n");
        }
        System.out.println(stringBuilder);
    }

    public static void showPurchasedLottosStatus(LottoWinningNumbers lottoWinningNumbers, Lottos lottos, long userPurchaseMoney) {

        System.out.println("당첨 통계");
        String hyphen = "-";
        System.out.println(hyphen.repeat(3));

        long profit = 0;
        int[] lottoResultCounts = new int[7];
        for (Lotto lotto : lottos.getLottos()) {
            LottoResult lottoResult = lotto.calculatePrize(lottoWinningNumbers);
            profit += lottoResult.getPrice();
            lottoResultCounts[lottoResult.getRank()]++;
        }

        System.out.println(LottoResult.FIFTH_PRIZE.getDescription() + " - " + lottoResultCounts[5] + "개");
        System.out.println(LottoResult.FOURTH_PRIZE.getDescription() + " - " + lottoResultCounts[4] + "개");
        System.out.println(LottoResult.THIRD_PRIZE.getDescription() + " - " + lottoResultCounts[3] + "개");
        System.out.println(LottoResult.SECOND_PRIZE.getDescription() + " - " + lottoResultCounts[2] + "개");
        System.out.println(LottoResult.FIRST_PRIZE.getDescription() + " - " + lottoResultCounts[1] + "개");

        double yield = (double) profit / userPurchaseMoney * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
