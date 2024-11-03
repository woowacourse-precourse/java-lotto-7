package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    public void printPublishedLotteries(List<Lotto> lotteries) {
        System.out.println("\n" + lotteries.size() + "개를 구매했습니다.");

        for (Lotto lotto : lotteries) {
            printEachNumber(lotto);
        }
    }

    public void printWinnings(Map<Rank, Integer> winningCountOfEachRanks) {
        System.out.println("\n" + "당첨 통계");
        System.out.println("---");

        for (Map.Entry<Rank, Integer> entry : winningCountOfEachRanks.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            System.out.println(rank.displayRankResult(count));
        }
    }

    public void printTotalRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    private void printEachNumber(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Integer integer : lotto.get()) {
            joiner.add(integer.toString());
        }

        System.out.println(joiner);
    }
}
