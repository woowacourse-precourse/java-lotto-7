package lotto.view;

import lotto.model.LottoBundle;
import lotto.model.LottoRanks;
import lotto.utils.LottoRank;

public class OutputView {
    public static void printPurchaseAmount(Integer amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printAllLottosNumbers(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.toString());
    }

    public static void printLottoBundleResultHeader() {
        System.out.println("당첨 통계\n---");
    }

    public static void printLottoRankResult(LottoRank lottoRank, Integer amount) {
        System.out.println(lottoRank.getDescription() + amount + "개");
    }

    public static void printTotalProfit(String profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
