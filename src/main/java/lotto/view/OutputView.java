package lotto.view;

import lotto.enumerate.Rank;
import lotto.model.Lottos;

import java.util.List;
import java.util.Map;

import static lotto.enumerate.OutputPrint.*;
import static lotto.enumerate.Rank.*;

public class OutputView {
    public void displayRankDistribution(Map<Rank, Integer> ranks) {
        List<Rank> winRanks = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
        System.out.println(OUTPUT_WIN_STRATAGE.getMsg());
        System.out.println(OUTPUT_SLASH.getMsg().repeat(3));
        printRank(ranks, winRanks);
    }

    private static void printRank(Map<Rank, Integer> ranks, List<Rank> winRanks) {
        for (Rank rank : winRanks) {
            System.out.print(rank.getRankPrintSentence());
            System.out.print(" " + OUTPUT_SLASH.getMsg() + " ");
            System.out.printf(OUTPUT_QUANTITY.getMsg(), ranks.getOrDefault(rank, 0));
            System.out.println();
        }
    }

    public void displayEarningRate(double calculate) {
        System.out.printf(OUTPUT_TOTAL_EARNING_RATE.getMsg(), calculate);
    }

    public void displayLottoPurchaseCount(int count) {
        System.out.printf(OUTPUT_BUY_QUANTITY.getMsg(), count);
    }

    public void displayLottoNumbers(Lottos lottos) {
        System.out.println();
        lottos.getLottos().forEach(System.out::println);
    }
}
