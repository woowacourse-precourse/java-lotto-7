package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printResults(Map<Rank, Integer> results, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        int totalPrize = 0;

        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            Rank rank = ranks[i];
            if (rank == Rank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, 0);
            totalPrize += count * rank.getPrize();
            printRankResult(rank, count);
        }

        double profit = ((double) totalPrize / purchaseAmount) * 100;
        profit = Math.round(profit * 10) / 10.0;
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public static void printRankResult(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", String.format("%,d", rank.getPrize()), count);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getMatchCount(), String.format("%,d", rank.getPrize()), count);
    }
}