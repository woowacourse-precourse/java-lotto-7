package lotto.io;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {

    public static void printPurchaseLottos(List<Lotto> lottos) {
        printLottoCount(lottos.size());
        printLottos(lottos);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printTotalResult(Map<Prize, Integer> prizeResult, double profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---\n");
        printPrizeResult(prizeResult, sb);
        printProfitRate(profitRate, sb);
        System.out.println(sb.toString());
    }

    private static void printPrizeResult(Map<Prize, Integer> prizeResult, StringBuilder sb) {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.MISS) {
                continue;
            }
            final int ZERO_MATCH_COUNT = 0;
            if (!prizeResult.containsKey(prize)) {
                sb.append(prize.toDefaultString()).append(" - ").append(ZERO_MATCH_COUNT).append("개\n");
                continue;
            }
            sb.append(prize.toDefaultString()).append(" - ").append(prizeResult.get(prize)).append("개\n");
        }
    }

    private static void printProfitRate(double profitRate, StringBuilder sb) {
        sb.append("총 수익률은 ").append(String.format("%.1f", profitRate)).append("%입니다.\n");
    }
}
