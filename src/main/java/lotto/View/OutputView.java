package lotto.View;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.Model.LottoPrizeMoney;

public class OutputView {

    public static void printEarningRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static void printLotto(List<List<Integer>> lottoNumbers, int count) {
        System.out.println(count + "개를 구매했습니다.");

        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }

        System.out.println();
    }

    public static void printWinningStatistics(List<Integer> matchNumberCount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = matchNumberCount.size() - 1; i >= 1; i--) {
            LottoPrizeMoney prize = LottoPrizeMoney.fromRank(i);
            int count = matchNumberCount.get(i);

            if (i == 2) {
                System.out.println(
                        prize.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + numberFormat.format(prize.getPrizeMoney())
                                + "원) - " + count
                                + "개");
            }
            if (i == 1 || i == 3 || i == 4 || i == 5) {
                System.out.println(
                        prize.getMatchNumber() + "개 일치 (" + numberFormat.format(prize.getPrizeMoney()) + "원) - " + count
                                + "개");
            }
        }
    }
}
