package lotto.view;

import lotto.Lotto;
import lotto.LottoCost;
import lotto.Rank;
import lotto.RankCalculator;

import java.util.List;
import java.util.Map;

import static lotto.Rank.*;

public class LottoOutput {
    private static final String PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void outputLottoNumbers(LottoCost lottoCost, List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottoCost.divideCostByUnit() + "개를 구매했습니다.");

        lottos.forEach(lotto -> {
            System.out.println(lotto.numbers().toString());
        });
    }

    public static void outputRankResult(RankCalculator rankCalculator) {
        Map<Rank, Integer> countOfRank = rankCalculator.getCountOfRank();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        countOfRank.keySet().stream()
                .sorted()
                .forEach(rank -> {
                    int count = countOfRank.get(rank);
                    if(rank != _NOT_WINNER) {
                        System.out.println(rank.getRankResult(count));
                    }
                });
        System.out.printf(PROFIT_FORMAT, rankCalculator.getProfit());
    }
}
