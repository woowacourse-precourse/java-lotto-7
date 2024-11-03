package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public abstract class OutputView {

    private OutputView() {
    }

    public static void showPurchaseLotto(int count, List<Lotto> lottos) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void showLottoResult(Map<LottoResult, Integer> lottoResultMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoResult result : LottoResult.values()) {
            int matchingCount = result.getMatchingCount();
            int winningAmount = result.getWinningAmount();
            int count = lottoResultMap.get(result);
            String rankName = result.name();

            System.out.print(matchingCount + "개 일치");
            if (rankName.equals("SECOND_PLACE")) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.println(" (" + String.format("%,d", winningAmount) + "원) - " + count + "개");
        }
    }

    public static void showEarningRate(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
