package lotto.View;

import java.util.List;
import lotto.Model.LottoPrizeMoney;

public class OutputView {

    public static void printEarningRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
    
    public static void printLotto(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    public static void printWinningStatistics(List<Integer> matchNumberCount) {

        for (int i = matchNumberCount.size() - 1; i >= 1; i--) {
            LottoPrizeMoney prize = LottoPrizeMoney.fromRank(i);
            int count = matchNumberCount.get(i);

            System.out.println(prize.getMatchNumber() + "개 일치 (" + prize.getPrizeMoney() + ") - " + count + "개");
        }
    }
}
