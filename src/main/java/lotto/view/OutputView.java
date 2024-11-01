package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {
    public static void printLottoCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lottoNumber : lottos.getLottos()) {
            System.out.println(lottoNumber);
        }
    }

    public static void printWinningStats(List<Integer> result) {
        System.out.println("\n당첨 통계\n---");
        int num = 4;
        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf("%s (%,d원) - %d개\n", lottoRank.getDescription(), lottoRank.getPrizeAmount(),
                    result.get(num));
            num--;
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f입니다.\n", profitRate);
    }
}
