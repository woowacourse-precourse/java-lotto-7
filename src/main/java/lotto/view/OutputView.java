package lotto.view;

import lotto.model.lotto.Lotto;
import lotto.model.result.LottoResult;
import lotto.model.result.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottoAmount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 %.1f%%입니다." + rateOfReturn);
    }

    // 구매한 로또 리스트 출력
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatisticHeader() {
        System.out.println("당첨 통계\n---");
    }

    // 당첨 결과 출력
    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Map<Rank, Integer> rankResults = lottoResult.getRankResults();

        for (Rank rank : Rank.values()) {
            if (rankResults.containsKey(rank)) {
                System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - "
                        + rankResults.get(rank) + "개");
            }
        }
    }
}
