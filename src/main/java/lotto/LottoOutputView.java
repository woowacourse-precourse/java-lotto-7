package lotto;

import java.util.List;
import java.util.Map;

public class LottoOutputView {
    public static void printPurchasedLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.MISS) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getPrize(), result.getOrDefault(rank, 0));
            }
        }
    }
}
