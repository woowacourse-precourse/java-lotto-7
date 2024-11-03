package lotto.View;

import java.util.List;

public class OutputView {

    // 구매한 로또의 개수와 번호를 출력한다.
    public static void printPurchasedLottos(int numberOfLottos, List<List<Integer>> lottoNumbers) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    // 당첨 내역을 출력한다.
    public static void printWinningStatistics(int[] matchCounts, double yield) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[4] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
