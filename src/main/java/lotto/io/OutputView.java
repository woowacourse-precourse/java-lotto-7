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

    public static void printTotalResult(Map<Prize, Integer> prizeResult, int purchaseAmount) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---\n");
        calculatePrizeResult(prizeResult, sb);
        System.out.println(sb.toString());
    }

    private static void calculatePrizeResult(Map<Prize, Integer> prizeResult, StringBuilder sb) {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.MISS) {
                continue;
            }
            if(!prizeResult.containsKey(prize)) {
                sb.append(prize.toDefaultString()).append(" - ").append(0).append("개\n");
                continue;
            }
            sb.append(prize.toDefaultString()).append(" - ").append(prizeResult.get(prize)).append("개\n");
        }
    }
}
