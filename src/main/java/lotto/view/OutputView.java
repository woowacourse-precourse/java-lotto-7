package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printRankResult(Map<Rank, Integer> rankResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getFormattedPrize() + ") - " + rankResult.get(rank) + "개");
            }
        }
    }

    public static void printYield(double yield) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedYield = df.format(yield);
        System.out.println("총 수익률은 " + formattedYield + "%입니다.");
    }
}
