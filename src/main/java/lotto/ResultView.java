package lotto;

import lotto.Lotto;
import lotto.Rank;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

	public static void printYield(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

	public static void printStatistics(Map<Rank, Integer> results) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, 0);
            if (rank == Rank.SECOND) {
                System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + formatPrize(rank.getPrize()) + ") - " + count + "개");
            } else {
                System.out.println(rank.getMatchCount() + "개 일치 (" + formatPrize(rank.getPrize()) + ") - " + count + "개");
            }
        }
    }

    private static String formatPrize(int prize) {
        return String.format("%,d원", prize);
    }

}