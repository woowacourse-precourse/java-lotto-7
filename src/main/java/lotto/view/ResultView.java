package lotto.view;

import static lotto.constants.ResultMessages.*;

import lotto.model.Lotto;
import lotto.model.Rank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(PURCHASED_COUNT + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printResults(Map<Rank, Integer> results, int purchaseAmount) {
        System.out.println(RESULT_HEADER);
        int totalPrize = calculateTotalPrize(results);
        printRankResults(results);
        printProfit(totalPrize, purchaseAmount);
    }

    private static int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    private static void printRankResults(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, 0);
            printRankResult(rank, count);
        }
    }

    private static void printRankResult(Rank rank, int count) {
        String prize = String.format("%,d", rank.getPrize());
        if (rank == Rank.SECOND) {
            System.out.printf((MATCH_COUNT_WITH_BONUS_RESULT) + "%n", prize, count);
            return;
        }
        System.out.printf((MATCH_COUNT_RESULT) + "%n", rank.getMatchCount(), prize, count);
    }

    private static void printProfit(int totalPrize, int purchaseAmount) {
        double profit = ((double) totalPrize / purchaseAmount) * 100;
        profit = Math.round(profit * 10) / 10.0;
        System.out.printf((TOTAL_PROFIT) + "%n", profit);
    }
}
