package lotto.view;

import lotto.domain.*;

import java.util.stream.IntStream;

public class OutputViewImpl implements OutputView {

    public void showLottos(Lottos lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.print(lotto.toString() + "\n");
        });
    }

    public void showResults(Results results, Money money) {
        System.out.println("\n당첨 통계\n" + "---");

        int[] o = new int[6];
        results.forEach(result -> {
            o[result.rank()]++;
        });

        IntStream.iterate(5, n -> n - 1)
                .limit(5)
                .forEach(rank -> {
                    Result result = Result.findByRank(rank);
                    System.out.println(result.getWinningNumberCount() + "개 일치" + isSecond(result, rank) + " (" + result.getPrize() + "원) - " + o[rank] + "개");
                });

        System.out.println("총 수익률은 " + results.getSumOfROI(money) + "%입니다.");
    }

    public String isSecond(Result result, Integer rank) {
        if (result.rank() == 2) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
